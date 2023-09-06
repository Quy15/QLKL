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


function click() {
    var m = document.getElementById("list").value;
    
    if (m == "0")
    {
        document.getElementById("chartContainer").style.display = "block";
        document.getElementById("chartContainer2").style.display = "none";
    }else if (m == "1"){
        document.getElementById("chartContainer").style.display = "none";
        document.getElementById("chartContainer2").style.display = "block";
    }
}



function save() {
    var sv1 = document.getElementById("sv1").value;
    var sv2 = document.getElementById("sv2").value;
    var thesisID = document.getElementById("thesisid").value;
    console.log(sv1 + sv2 + thesisID);

    fetch("/QuanLyKhoaLuan/api/thesisParticipant", {
        method: "post",
        body: JSON.stringify({
            "id1": sv1 + "",
            "id2": sv2 + "",
            "thesisid": thesisID + ""
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then((res) => res.json()).then((data) => {
        if (data["status"] == "true") {
            location.replace("/QuanLyKhoaLuan/instructorThesis")
        }
    });


}

function saveI() {
    var gv1 = document.getElementById("gv1").value;
    var gv2 = document.getElementById("gv2").value;
    var thesisID = document.getElementById("thesisid2").value;
    console.log(gv1 + gv2 + thesisID);

    fetch("/QuanLyKhoaLuan/api/saveinstructor", {
        method: "post",
        body: JSON.stringify({
            "id1": gv1 + "",
            "id2": gv2 + "",
            "thesisid": thesisID + ""
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then((res) => res.json()).then((data) => {
        if (data["status"] == "true") {
            location.replace("/QuanLyKhoaLuan/thesisManager")
        }
    });


}


