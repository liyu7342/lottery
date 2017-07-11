var timers;
//定义全局变量，保存所有文件信息
function preLoad() {
    if (!this.support.loading) {
        alert("You need the Flash Player 9.028 or above to use SWFUpload.");
        return false;
    }
}
function loadFailed() {
    alert("Something went wrong while loading SWFUpload. If this were a real application we'd clean up and then give you an alternative");
}
function fileQueueError(file, errorCode, message) {
    try {
        var imageName = "error.gif";
        var errorName = "";
        if (errorCode === SWFUpload.errorCode_QUEUE_LIMIT_EXCEEDED) {
            errorName = "You have attempted to queue too many files.";
        }

        if (errorName !== "") {
            alert(errorName);
            return;
        }

        switch (errorCode) {
            case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE:
                imageName = "zerobyte.gif";
                break;
            case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT:
                imageName = "toobig.gif";
                break;
            case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE:
            case SWFUpload.QUEUE_ERROR.INVALID_FILETYPE:
            default:
                alert(message);
                break;
        }

        //addImage("images/" + imageName);

    } catch (ex) {
        this.debug(ex);
    }

}
//页面 上传 按钮调用的方法
function UploadFile() {
    loadTips.showLoading();
    var postobj = { "TicktID": ticktTid };
    swfu.setPostParams(document.cookie);//针对360极速模式上传不了问题做处理
    swfu.setPostParams(postobj);
    swfu.startUpload();
}
function fileDialogComplete(numFilesSelected, numFilesQueued) {
    try {
        if (numFilesQueued > 0) {
            TabInit(quedata);//初始化表格
            UploadFile();
        }
    } catch (ex) {
        this.debug(ex);
    }
}

function uploadProgress(file, bytesLoaded) {

    try {
        var percent = Math.ceil((bytesLoaded / file.size) * 100);

        var progress = new FileProgress(file, this.customSettings.upload_target);
        progress.setProgress(percent, file);
        if (percent === 100) {
            //progress.setStatus("Creating thumbnail...");
            progress.toggleCancel(false, this);
        } else {
            progress.setProgress(50, file);//特殊处理，先上传到服务器再上传到阿里云，所以显示50%
            //progress.setStatus("上传到队列，等待上传...", file);
            progress.toggleCancel(true, this);
        }
    } catch (ex) {
        this.debug(ex);
    }
}

//单个文件上传到本地服务器成功
function uploadSuccess(file, serverData) {
    try {
        quedata.push(eval('(' + serverData + ')'));
        TabInit(quedata);//加载数据
        progress.toggleCancel(false);
    } catch (ex) {
        this.debug(ex);
    }
}
//所有文件都上传到本地服务器之后，在后台开启多线程上传文件
function uploadComplete(file) {
    try {
        /*  I want the next upload to continue automatically so I'll call startUpload here */
        if (this.getStats().files_queued > 0) {
            this.startUpload();
        } else {
            loadTips.hideLoadind();
        }
    } catch (ex) {
        this.debug(ex);
    }
}
function uploadError(file, errorCode, message) {
    var imageName = "error.gif";
    var progress;
    try {
        switch (errorCode) {
            case SWFUpload.UPLOAD_ERROR.FILE_CANCELLED:
                try {
                    progress = new FileProgress(file, this.customSettings.upload_target);
                    progress.setCancelled();
                    progress.setStatus("Cancelled");
                    progress.toggleCancel(false);
                }
                catch (ex1) {
                    this.debug(ex1);
                }
                break;
            case SWFUpload.UPLOAD_ERROR.UPLOAD_STOPPED:
                try {
                    progress = new FileProgress(file, this.customSettings.upload_target);
                    progress.setCancelled();
                    progress.setStatus("Stopped");
                    progress.toggleCancel(true);
                }
                catch (ex2) {
                    this.debug(ex2);
                }
            case SWFUpload.UPLOAD_ERROR.UPLOAD_LIMIT_EXCEEDED:
                imageName = "uploadlimit.gif";
                break;
            default:
                progress.setStatus("Stopped");
                progress.toggleCancel(false);
                break;
        }

        addImage("images/" + imageName);

    } catch (ex3) {
        this.debug(ex3);
    }

}

function addImage(src) {
    var newImg = document.createElement("img");
    newImg.style.margin = "5px";

    document.getElementById("thumbnails").appendChild(newImg);
    if (newImg.filters) {
        try {
            newImg.filters.item("DXImageTransform.Microsoft.Alpha").opacity = 0;
        } catch (e) {
            // If it is not set initially, the browser will throw an error.  This will set it if it is not set yet.
            newImg.style.filter = 'progid:DXImageTransform.Microsoft.Alpha(opacity=' + 0 + ')';
        }
    } else {
        newImg.style.opacity = 0;
    }

    newImg.onload = function () {
        fadeIn(newImg, 0);
    };
    newImg.src = src;
}

function fadeIn(element, opacity) {
    var reduceOpacityBy = 5;
    var rate = 30;	// 15 fps


    if (opacity < 100) {
        opacity += reduceOpacityBy;
        if (opacity > 100) {
            opacity = 100;
        }

        if (element.filters) {
            try {
                element.filters.item("DXImageTransform.Microsoft.Alpha").opacity = opacity;
            } catch (e) {
                // If it is not set initially, the browser will throw an error.  This will set it if it is not set yet.
                element.style.filter = 'progid:DXImageTransform.Microsoft.Alpha(opacity=' + opacity + ')';
            }
        } else {
            element.style.opacity = opacity / 100;
        }
    }

    if (opacity < 100) {
        setTimeout(function () {
            fadeIn(element, opacity);
        }, rate);
    }
}



/* ******************************************
 *	FileProgress Object
 *	Control object for displaying file info
 * ****************************************** */

function FileProgress(file, targetID) {
    this.fileProgressID = "divFileProgress";//"progress"+file.id//
    this.fileProgressWrapper = document.getElementById(this.fileProgressID);
    if (!this.fileProgressWrapper) {

        this.fileProgressWrapper = document.createElement("div");
        this.fileProgressWrapper.className = "progressWrapper";
        this.fileProgressWrapper.id = this.fileProgressID;

        this.fileProgressElement = document.createElement("div");
        this.fileProgressElement.className = "progressContainer";

        var progressCancel = document.createElement("a");
        progressCancel.className = "progressCancel";
        progressCancel.href = "#";
        progressCancel.style.visibility = "hidden";
        progressCancel.appendChild(document.createTextNode(" "));

        var progressText = document.createElement("div");
        progressText.className = "progressName";
        progressText.appendChild(document.createTextNode(file.name));

        var progressBar = document.createElement("div");
        progressBar.className = "progressBarInProgress";

        var progressStatus = document.createElement("div");
        progressStatus.className = "progressBarStatus";
        progressStatus.innerHTML = "&nbsp;";

        this.fileProgressElement.appendChild(progressCancel);
        this.fileProgressElement.appendChild(progressText);
        this.fileProgressElement.appendChild(progressStatus);
        this.fileProgressElement.appendChild(progressBar);

        this.fileProgressWrapper.appendChild(this.fileProgressElement);

        //document.getElementById(targetID).appendChild(this.fileProgressWrapper);
        //$("#progress" + file.id).html(this.fileProgressWrapper);
        fadeIn(this.fileProgressWrapper, 0);

    } else {
        this.fileProgressElement = this.fileProgressWrapper.firstChild;
        this.fileProgressElement.childNodes[1].firstChild.nodeValue = file.name;

    }
    //alert(file.id);
    this.height = this.fileProgressWrapper.offsetHeight;

}

FileProgress.prototype.setProgress = function (percentage, file) {
    //this.fileProgressElement.className = "progressContainer green";
    //this.fileProgressElement.childNodes[3].className = "progressBarInProgress";
    //this.fileProgressElement.childNodes[3].style.width = percentage + "%";
    //var html = "<div class=\"progressContainer green\" style=\"width:" + (percentage > 100 ? 100 : percentage) + "%\">" + (percentage > 100 ? 100 : percentage) + "%</div>";
    $("#process" + filesToContorlsID.getControlId(file.name)).css("width", (percentage > 100 ? 100 : percentage) + "%");
};
FileProgress.prototype.setComplete = function () {
    this.fileProgressElement.className = "progressContainer blue";
    this.fileProgressElement.childNodes[3].className = "progressBarComplete";
    this.fileProgressElement.childNodes[3].style.width = "";
};
FileProgress.prototype.setError = function () {
    this.fileProgressElement.className = "progressContainer red";
    this.fileProgressElement.childNodes[3].className = "progressBarError";
    this.fileProgressElement.childNodes[3].style.width = "";

};
FileProgress.prototype.setCancelled = function () {
    //this.fileProgressElement.className = "progressContainer";
    //this.fileProgressElement.childNodes[3].className = "progressBarError";
    //this.fileProgressElement.childNodes[3].style.width = "";

};
FileProgress.prototype.setStatus = function (status, file) {
    //this.fileProgressElement.childNodes[2].innerHTML = status;
    $("#status" + filesToContorlsID.getControlId(file.name)).html(status);
};

FileProgress.prototype.toggleCancel = function (show, swfuploadInstance) {
    this.fileProgressElement.childNodes[0].style.visibility = show ? "visible" : "hidden";
    if (swfuploadInstance) {
        var fileID = this.fileProgressID;
        this.fileProgressElement.childNodes[0].onclick = function () {
            swfuploadInstance.cancelUpload(fileID);
            return false;
        };
    }
};
