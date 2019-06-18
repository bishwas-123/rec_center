(function($) {
    $.fn.inputFilter = function(inputFilter) {
        return this.on("input keydown keyup mousedown mouseup select contextmenu drop", function() {
            if (inputFilter(this.value)) {
                this.oldValue = this.value;
                this.oldSelectionStart = this.selectionStart;
                this.oldSelectionEnd = this.selectionEnd;
            } else if (this.hasOwnProperty("oldValue")) {
                this.value = this.oldValue;
                this.setSelectionRange(this.oldSelectionStart, this.oldSelectionEnd);
            }
        });
    };

    $("#userId-checkIn").inputFilter(function(value) {
        return /^\d*$/.test(value);
    });
}(jQuery));
// $("#userId-checkIn").inputFilter(function(value) {
//     return /^\d*$/.test(value) (value === "" || parseInt(value) <= 9999999);
// });
