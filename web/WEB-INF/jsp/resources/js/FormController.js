var FormController = function () {
    
    this.sendForm = function (form) {
        var fd = new FormData(),
            xhr = new XMLHttpRequest(),
            upload = xhr.upload,
            method = "POST"
            fields = form.getElementsByTagName("input");
            
        for (var i = 0; i < fields.length; i++) {
            if (fields[i].type != "submit") {
                if (fields[i].type == "file") {
                    for (var j = 0; j < fields[i].files.length; j++) {
                        fd.append("upload", fields[i].files[j]);
                    }
                } else fd.append(fields[i].name, fields[i].value);
            }
        }
        
        document.getElementById("statusText").textContent = "(uploading...)";
        
        upload.addEventListener("progress", this.showProgress, false);
        upload.addEventListener("load", this.loaded, false);
        upload.addEventListener("error", function (ev) {console.log(ev)}, false);
        
        if (form.method && form.method.length)
            method = form .method;
        
        xhr.open(method, form.action);
        xhr.send(fd);
        xhr.addEventListener("readystatechange", this.showResponse, false);
    }
    
    this.addFormHandler = function (form) {
        try {
            if (form && form.action) {
                form.addEventListener("submit", function (ev) {
                    ev.preventDefault();
                    
                    ev.stopPropagation();
                    FormController.sendForm(this);
                    return false;
                }, false);
            } else throw "noForm";
        } catch (ex) {
            if (ex == "noForm")
                console.log("Form is null or has no action");
            else alert(ex.message);
        }
    }
    
    this.showProgress = function (ev) {
        if (ev.lengthComputable) {
            var pct = Math.round((ev.loaded / ev.total) * 100);
            updateProgressIndicators(pct);
        }
    }
    
    this.loaded = function () {
        updateProgressIndicators(100);
    }
    
    this.showResponse = function () {
        var statusText = document.getElementById("statusText");
        switch (this.readyState) {
            case 3:
                statusText.textContent = "(receiving response)"
                break;
            case 4:
                statusText.textContent = "(finished!)"
                //document.getElementById("uploadSummary").innerHTML = this.responseText;
                
                var userId = $('#userId').val();
                $.ajax({
                    
                    url:'album/LoadMoreUserAlbums/'+userId+"/"+0,
                    type:'post',
                    data:{userId:userId}
                }).success(function(data){
                    $('#uploadImagesForm').dialog('close');
                    $('#userAlbums').html(data);
                    
                }).error(function(){
                    
                    alert('gyu');
                });
        }
    }
    
    this.updateFileList = function () {
        var files = this.files;
        if (files) {
            var fileList = document.getElementById("fileList");
            while(fileList.childNodes.length) {
                fileList.removeChild(fileList.firstChild);
            }
            for (var i = 0; i < files.length; i++) {
                var li = document.createElement("li");
                li.textContent = files[i].name + " ( " + Math.round(files[i].size / 1024) + "KB )";
                fileList.appendChild(li);
            }
        }
    }
    
    var updateProgressIndicators = function (pct) {
        var pBar = document.getElementById("progressBar");
        var pText = document.getElementById("percentage");
        pBar.style["width"] = pct + "%";
        pText.textContent = pct;
    }
    
};
