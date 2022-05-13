
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
 url : "OfficialAPI", 
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
if ($("#firstName").val().trim() == "") 
 { 
 return "Insert Item Code."; 
 } 
// NAME
if ($("#lastName").val().trim() == "") 
 { 
 return "Insert Item Name."; 
 } 
 
// PRICE-------------------------------
if ($("#date").val().trim() == "") 
 { 
 return "Insert Item Price."; 
 } 
// is numerical value

// DESCRIPTION------------------------
if ($("#gender").val().trim() == "") 
 { 
 return "Insert Item Description."; 
 } 
return true; 
}



$(document).on("click", ".btnUpdate", function(event) 
{ 
 $("#hidItemIDSave").val($(this).data("itemid")); 
 $("#firstName").val($(this).closest("tr").find('td:eq(0)').text()); 
 $("#lastName").val($(this).closest("tr").find('td:eq(1)').text()); 
 $("#date").val($(this).closest("tr").find('td:eq(2)').text()); 
 $("#gender").val($(this).closest("tr").find('td:eq(3)').text()); 
 $("#father").val($(this).closest("tr").find('td:eq(4)').text()); 
 $("#mother").val($(this).closest("tr").find('td:eq(5)').text()); 
$("#designation").val($(this).closest("tr").find('td:eq(6)').text());
$("#department").val($(this).closest("tr").find('td:eq(7)').text());  
});

$(document).on("click", ".btnRemove", function(event) 
{ 
 $.ajax( 
 { 
 url : "OfficialAPI", 
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
