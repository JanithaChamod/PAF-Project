/**
 * 
 */
$(document).on("click", "#btnSave", function(event) 
{ 
// Clear alerts---------------------
 $("#alertSuccess").text(""); 
 $("#alertSuccess").hide(); 
 $("#alertError").text(""); 
 $("#alertError").hide(); 
// Form validation-------------------
var status = validateItemForm(); 
if (status != true) 
 { 
 $("#alertError").text(status); 
 $("#alertError").show(); 
 return; 
 } 
// If valid------------------------
var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT"; 
 $.ajax( 
 { 
 url : "TimesheetAPI", 
 type : type, 
 data : $("#formItem").serialize(), 
 dataType : "text", 
 complete : function(response, status) 
 { 
 onItemSaveComplete(response.responseText, status); 
 } 
 }); 
});

function onItemSaveComplete(response, status) 
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully saved."); 
 $("#alertSuccess").show(); 
 $("#divItemsGrid").html(resultSet.data); 
 } else if (resultSet.status.trim() == "error") 
 { 
 $("#alertError").text(resultSet.data); 
 $("#alertError").show(); 
 } 
 } else if (status == "error") 
 { 
 $("#alertError").text("Error while saving."); 
 $("#alertError").show(); 
 } else
 { 
 $("#alertError").text("Unknown error while saving.."); 
 $("#alertError").show(); 
 } 
 
 $("#hidItemIDSave").val(""); 
 $("#formItem")[0].reset(); 
}
// CLIENT-MODEL================================================================
function validateItemForm() 
{ 
// CODE
if ($("#email").val().trim() == "") 
 { 
 return "Insert email."; 
 } 
// NAME
if ($("#workTitle").val().trim() == "") 
 { 
 return "Insert Work Title."; 
 } 
 
// PRICE-------------------------------
if ($("#workDescription").val().trim() == "") 
 { 
 return "Insert work description"; 
 } 
// is numerical value

// DESCRIPTION------------------------
if ($("#total").val().trim() == "") 
 { 
 return "Insert total working hours."; 
 } 
if ($("#date").val().trim() == "") 
 { 
 return "Insert date."; 
 } 
return true; 
}



$(document).on("click", ".btnUpdate", function(event) 
{ 
 $("#hidItemIDSave").val($(this).data("itemid")); 
 $("#email").val($(this).closest("tr").find('td:eq(0)').text()); 
 $("#workTitle").val($(this).closest("tr").find('td:eq(1)').text()); 
 $("#workDescription").val($(this).closest("tr").find('td:eq(2)').text()); 
 $("#total").val($(this).closest("tr").find('td:eq(3)').text()); 
$("#date").val($(this).closest("tr").find('td:eq(3)').text());
 
});

$(document).on("click", ".btnRemove", function(event) 
{ 
 $.ajax( 
 { 
 url : "TimesheetAPI", 
 type : "DELETE", 
 data : "itemID=" + $(this).data("itemid"),
 dataType : "text", 
 complete : function(response, status) 
 { 
 onItemDeleteComplete(response.responseText, status); 
 } 
 }); 
});

function onItemDeleteComplete(response, status) 
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully deleted."); 
 $("#alertSuccess").show(); 
 $("#divItemsGrid").html(resultSet.data); 
 } else if (resultSet.status.trim() == "error") 
 { 
 $("#alertError").text(resultSet.data); 
 $("#alertError").show(); 
 } 
 } else if (status == "error") 
 { 
 $("#alertError").text("Error while deleting."); 
 $("#alertError").show(); 
 } else
 { 
 $("#alertError").text("Unknown error while deleting.."); 
 $("#alertError").show(); 
 } 
}
/**
 * 
 *//**
 * 
 *//**
 * 
 */