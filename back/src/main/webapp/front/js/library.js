window.addEventListener('load', () => {
    const likeObj = document.getElementById('like')
    const fObj = document.querySelector('following')

    //--좋아요누른글 버튼클릭되었을 때 할 일 START--
    likeObj.addEventListener('click', (e) => {

        // Create an XMLHttpRequest object
        const xhttp = new XMLHttpRequest();
        e.preventDefault(); 
        // Define a callback function
        xhttp.addEventListener('load', (e) => {
            // Here you can use the Data
            console.log(e.target)
            likeObj.innerHTML = e.target.responseText;
        })

        xhttp.open("GET", "http://localhost:5500/html/signup.html");
        xhttp.setRequestHeader("Content-type",
            "application/x-www-form-urlencoded")
        xhttp.send();
    })
    //--좋아요누른글 버튼클릭되었을 때 할 일 END--
})