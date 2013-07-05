<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />

  <title>Ajax uploads using the FormData interface</title>
 
  <link rel="stylesheet" media="screen" type="text/css" href="css/democss/style.css" />
</head>

<body>
    
        
    <div style="width:300px;margin:auto;position: relative; right: 5%;">    
        <form id="uploader" action="UploadImage" method="post" enctype="multipart/form-data">
            <fieldset>
                <legend>Choose some files to upload</legend>
                
                <input class="grad" type="hidden" name="name" value="77"/>
                
                <p id="fileField">
                    <input type="file" name="upload[]" multiple/>
                </p>
                <div id="fileListWrap"  class="grad">
                    <ol id="fileList">
                        <!--- populated by js --->
                    </ol>
                    <a id="addFiles" href="#" title="Add some files">
                        <img src="images/add.png" alt="Add files" width="24" height="24" />
                    </a>
                </div>
                <p id="controls">
                    <input class="blueButtonLink" type="submit" name="doit" value="upload" />
                </p>
            </fieldset>
        </form>
        
        <div  style="clear: both"></div>
        <div id="updateArea" style="width:100%">
            <div id="progressBarOuter">
                <div id="progressBar"></div>
            </div>
            <p id="progressMeta">
                <span id="statusText"></span>&nbsp;
                <span id="percentage">0</span>&#37;
            </p>
        </div>
        </div>
        
    
    <script src="js/FormController.js"></script>
    <script>
        window.onload = function () {
            if (typeof File == "undefined") alert("Sorry but your browser does not support the file API and this demo will not work for you.");
            var form = document.getElementById("uploader");
            var addFiles = document.getElementById("addFiles");
            FormController = new FormController();

            FormController.addFormHandler(form);
            
            form["upload[]"].addEventListener("change", FormController.updateFileList, false);
            addFiles.addEventListener("click", function (ev) {
                ev.preventDefault();
                form["upload[]"].click();
            }, false);
        }
    </script>
</body>
</html>