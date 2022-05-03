function delReq(uri) {
    fetch(uri, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(e => {
        window.alert("Deleted");
    }).catch(e => {
        window.alert("Error");
    });
}