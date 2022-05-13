
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
 url : "ContactAPI", 
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
if ($("#currentAddress").val().trim() == "") 
 { 
 return "Insert current address."; 
 } 
// NAME
if ($("#permanentAddress").val().trim() == "") 
 { 
 return "Insert permanent address."; 
 } 
 
// PRICE-------------------------------
if ($("#email").val().trim() == "") 
 { 
 return "Insert email."; 
 } 
// is numerical value

// DESCRIPTION------------------------
if ($("#contactNumber").val().trim() == "") 
 { 
 return "Insert contact Number."; 
 } 
return true; 
}



$(document).on("click", ".btnUpdate", function(event) 
{ 
 $("#hidItemIDSave").val($(this).data("itemid")); 
 $("#currentAddress").val($(this).closest("tr").find('td:eq(0)').text()); 
 $("#permanentAddress").val($(this).closest("tr").find('td:eq(1)').text()); 
 $("#email").val($(this).closest("tr").find('td:eq(2)').text()); 
 $("#contactNumber").val($(this).closest("tr").find('td:eq(3)').text()); 
 $("#higherEducation").val($(this).closest("tr").find('td:eq(4)').text()); 
 $("#language").val($(this).closest("tr").find('td:eq(5)').text()); 
$("#primarySkill").val($(this).closest("tr").find('td:eq(6)').text());
$("#secondarySkill").val($(this).closest("tr").find('td:eq(7)').text());  
});

$(document).on("click", ".btnRemove", function(event) 
{ 
 $.ajax( 
 { 
 url : "ContactAPI", 
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
 */