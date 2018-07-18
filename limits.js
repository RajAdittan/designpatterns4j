
var table = {}

function setGlobal(name, object) {
    table[name] = object;
}

function execute(result) {
    var order = table["order"];
    // print (order.toString());
    if(checkSizeLimit(order)) {
        result.setSuccess(true);
        return;
    }
    result.setSuccess(false);
}

//limit check 1: checks order.quantity is > 10000
function checkSizeLimit(order) {
    var orderSize = order.getQuantity();
    if(orderSize > 10000 || 1 > orderSize) return false;
    return true;
}