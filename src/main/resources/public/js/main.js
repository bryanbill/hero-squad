function delReq(id) {
    // Get the current path
    let path = window.location.pathname;
 console.log(path);
    fetch(`${path}/${id}/delete`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(e => {
       window.location.reload();
    }).catch(e => {
        window.alert("Error");
    });
}