   console.log("File Loded")

   //change page theme start
   let CurrentTheme = getTheme();


   document.addEventListener("DOMContentLoaded", function() {
       changeTheme();
   });
     function changeTheme()
     {
       changePageTheme(CurrentTheme,CurrentTheme);

       const theme_change = document.querySelector('#theme_change_button');


       const oldTheme = CurrentTheme;

       theme_change.addEventListener("click", (event) => {
           const oldTheme = CurrentTheme;
           console.log("Button clicked theme changed");
           document.querySelector('html').classList.remove(CurrentTheme);
           if (CurrentTheme === "light"){

               CurrentTheme = "dark";
           }
           else{
               CurrentTheme = "light";
           }
           changePageTheme(CurrentTheme,oldTheme);

       });
     }


//setTheme to local storage
    function setTheme(theme)
    {
    localStorage.setItem("theme", theme);
    }


//getTheme from localstorage
    function getTheme()
    {
    let theme = localStorage.getItem("theme");
    return theme ? theme : "light";
    }


    function changePageTheme(theme,oldTheme){
        setTheme(CurrentTheme);
        document.querySelector('html').classList.remove(oldTheme);
        document.querySelector('html').classList.add(CurrentTheme);
        document.querySelector("#theme_change_button").
        querySelector("span").textContent = theme === "dark" ? "light" : "dark";

    }

   //change page theme end