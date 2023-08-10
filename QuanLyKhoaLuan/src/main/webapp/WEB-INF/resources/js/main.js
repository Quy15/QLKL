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

function addMem() {
    var html = '<div class="row">'+ '<div class="row"><input type="text" class="form-control" placeholder="Enter email" name="email"><label class="form-label" for="form3Example3c">Thành viên</label>' + '</div>' + '<div class="row"><input type="password" class="form-control" placeholder="Enter password" name="pswd"><label class="form-label" for="form3Example3c">Vai trò</label>' + '</div>' + '</div>';
    document.getElementById('input').insertAdjacentHTML('afterend', html);
}