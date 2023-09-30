window.onload = function(){   
    createPagination();
}
let currentPage = 1;
let activePage = currentPage;



function createPagination(){
    let rowsPerPage =  6; 
    let tableRows = document.querySelectorAll('#tablePagination tbody tr');   
    let pageCount = Math.ceil(tableRows.length / rowsPerPage); 
    let pagination = document.getElementById('pagination');
    pagination.innerHTML = '';
   

    let liPrevBtn = document.createElement("li");
    liPrevBtn.classList.add("page-item")
    let prevBtn = document.createElement("a")    
    prevBtn.classList.add("page-link")
    prevBtn.href = "#";
    prevBtn.innerText = "Předchozí";

    let liNextBtn = document.createElement("li");
    liNextBtn.classList.add("page-item");
    let nextBtn = document.createElement("a");
    nextBtn.classList.add("page-link");
    nextBtn.href = "#";
    nextBtn.innerText = "Další"

    prevBtn.onclick = function(){
        if(currentPage > 1){
            currentPage--;
            activePage--;
        }
        showPage(currentPage)
    };
    
    nextBtn.onclick = function(){
        if(currentPage <= pageCount){
            currentPage++;
            activePage++;
        }
        showPage(currentPage);
    };

    liPrevBtn.appendChild(prevBtn);
    pagination.appendChild(liPrevBtn);    

    for(let i = 1; i <= pageCount; i ++){
        let li = document.createElement("li");
        li.classList.add("page-item")
        let link = document.createElement("a");
        link.classList.add("page-link")
        link.href = "#";
        link.innerText = i;     

        link.onclick = function(){
            currentPage = i;
            showPage(currentPage);
            
            
        };

        li.appendChild(link);
        pagination.appendChild(li);
    }
    liNextBtn.appendChild(nextBtn);
    pagination.appendChild(liNextBtn);
    showPage(currentPage);
    
    function showPage(pageNumber){
        for(let i = 0; i < tableRows.length; i++){
            if(i >= (pageNumber - 1) * rowsPerPage && i < pageNumber * rowsPerPage){
                tableRows[i].style.display = 'table-row';
                }else{
                    tableRows[i].style.display = 'none';
                }
        }
        console.log(activePage);
        markActivePage();

        if(pageNumber == 1){
            liPrevBtn.classList.add("disabled");
        }else{
            liPrevBtn.classList.remove("disabled")
        }
        if(pageNumber == pageCount){
            liNextBtn.classList.add("disabled");
        }else{
            liNextBtn.classList.remove("disabled");
        }
       
    }

    function markActivePage() {
        
        let allLinks = document.querySelectorAll(".page-item");
        allLinks.forEach(function (item) {
            item.classList.remove("active");
        });
    
        
        let currentLink = document.querySelector(
            `.page-item:nth-child(${currentPage + 1})`
        );
        if (currentLink) {
            currentLink.classList.add("active");
        }
    }

}




