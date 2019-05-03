
function create() {
    var inputName = document.getElementById("input-create").value;
    fetch("hello/create",{
            method:"POST",
            headers: new Headers({'Content-Type': 'application/x-www-form-urlencoded'}),
            body: "name="+inputName
    })
    .then(response => {
        if (response.ok){
            location.reload();
        }else{
            alert(response.text());
        }
    })
    .catch(error => console.error(error))
}

function update(id) {
    var inputName = document.getElementById("input-update-"+id).value;
    fetch("hello/update/"+id,{
            method:"PUT",
            headers: new Headers({'Content-Type': 'application/x-www-form-urlencoded'}),
            body: "name="+inputName
    })
    .then(response => {
        if (response.ok){
            location.reload();
        }else{
            alert(response.text());
        }
    })
    .catch(error => console.error(error))
}

function remove(id) {
    fetch("hello/delete/"+id,{
            method:"DELETE",
    })
    .then(response => {
        if (response.ok){
            location.reload();
        }else{
            alert(response.text());
        }
    })
    .catch(error => console.error(error))
}