function deleteThesis(path) {
    if (confirm("Bạn chắc chắn xóa không ?") === true)
    {
        fetch(path, {
            method: "delete"
        }).then(res => {
            if (res.status === 204)
                location.reload();
            else
                alert("Hệ thống lỗi ! Quay lại sau");
        });
    }
}

function deleteUser(path) {
    if (confirm("Bạn chắc chắn xóa không ?") === true)
    {
        fetch(path, {
            method: "delete"
        }).then(res => {
            if (res.status === 204)
                location.reload();
            else
                alert("Hệ thống lỗi ! Quay lại sau");
        });
    }
}

//var index;
//$(document).ready(function(){
//    $("#btnAdd").click(function(){
//        var x = document.getElementById("defenseuser").rows.length-1;
//        window.index = x + 1;
//        
//        row = '<tr id = "' + index + '"/>';
//        row += '<td style="border: 1px solid; border-collapse: collapse;" class="ordinal">' + index + '</td>';
//        
//        row += '<td style="border: 1px solid; border-collapse: collapse;">' +
//                    '<form:select class="form-select" id="user" name="user" path="id">' +
//                    '<c:forEach items="${user}" var="u">' +
//                        '<c:forEach items="${role}" var="r">'+
//                            '<c:if test="${r.id == u.roleId.id}">' +
//                                '<option value="${u.id}">${u.firstName} ${u.lastName}</option>' +
//                            '</c:if>'+
//                        '</c:forEach>' +
//                    '</c:forEach>' +
//                    '</form:select>' +
//                '</td>' +
//                '<td>' +
//                    '<input class="btn-danger" type="button" onclick="deleteRow(1)" value="X"/>' +
//                '</td>' +
//                '</tr>';
//        
//        row += '<td style="border: 1px solid; border-collapse: collapse;">' +
//                    '<select class="form-select" id="user" name="user">' +
//                        '<c:forEach items="${role}" var="r">'+  
//                                '<option value="${r.id}">${r.name}</option>' +
//                        '</c:forEach>' +
//                    '</select>' +
//                '</td>' +
//                '<td>' +
//                    '<input class="btn-danger" type="button" onclick="deleteRow(1)" value="X"/>' +
//                '</td>' +
//                '</tr>';
//        $('.addUser').append(row);
//    })
//})