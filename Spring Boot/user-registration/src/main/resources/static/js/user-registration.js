document.getElementById('registration-form').addEventListener('submit', async function(e){
    e.preventDefault();
    const formData=new FormData(this)
    const data={
        username:formData.get('username'),
        fname:formData.get('fname'),
        lname:formData.get('lname'),
        mobile:formData.get('mobile'),
        mail:formData.get('mail'),
        address:formData.get('address'),
        dob: formData.get('dob'),
        password: formData.get('password')
    };

    if(data.password==formData.get('re-password')){
        const response=fetch('/api/user',{
            method:'POST',
            headers:{
                'Content-Type':'application/json'
            },
            body:JSON.stringify(data)
        })
            .then(response=>{
                if(response.ok){
                    // User created, redirect to success page
                    window.location.href="/register/success"
                }
                else if(response.status===409) alert("User already exists with this username or mail")
                else alert("Registration failed")
            })
            .catch(error=>{
                console.error("Error occurred");
                alert("Error occurred")
            })
    }
    else alert("Passwords didn't mtach")
});