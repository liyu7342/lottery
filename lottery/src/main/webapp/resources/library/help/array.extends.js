/**
 * Created by Administrator on 2017/5/12.
 */

Array.prototype.indexOfByAttr = function (attr,val) {
    for (var i = 0; i <this.length; i++) {
        if (this[i][attr] == val) return i;
    }
    return -1;
};
Array.prototype.indexOfById=function(val){
    return this.indexOfByAttr("id",val);
}

Array.prototype.removeByAttr = function (attr,val) {
    var index = this.indexOfByAttr(attr,val);
    if (index > -1) {
        this.splice(index, 1);
    }
};

Array.prototype.removeById = function (val) {
    var index = this.indexOfById(val);
    if (index > -1) {
        this.splice(index, 1);
    }
};


Array.prototype.remove = function (val) {
    var index = this.indexOf(val);
    if (index > -1) {
        this.splice(index, 1);
    }
};
