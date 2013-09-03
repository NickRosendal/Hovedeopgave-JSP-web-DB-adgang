// we retirve the canvas element from html
var canvas = document.getElementById("bargraph");
// we retrive the 2d context of the canvas element
var bargraph = canvas.getContext("2d");
 
// so long we have our object in with we can draw (bargraph variable)
 
// because I want to put some text (number) below every bar I have to get the canvas width and height and to cut of some height from it for this footer
var canvasW = canvas.offsetWidth;       // used for printing the line above bars
var canvasH = canvas.offsetHeight;      // the canvas height
var footerH = 30;                       // the height of the bottom where the text will be displayed
var maxBarH = canvasH - footerH;        // the maximum bar height = the canvas height - the footer where the number will be placed
var scaleH = maxBarH / 100;             // the echivalent of 1% the maximum bar height (to print the bars)
var offset = 5;                         // initial x position (used between elements - horizontally)
var barWidth = 35;


function drawBarGraph() {
   
    drawLinesAboveBars();
 

    // max number is 100 there for this is %!!!
    drawBar(93, '19/8', '#123');
    drawBar(95, '28/8', '#421');
    drawBar(65, '3/9', '#444');
    drawBar(83, '22/10', '#444');
    
    

}
 
// The function drawLinesAboveBars
function drawLinesAboveBars() {
    // in case you don't know the canvas element uses the coordonate systems with the origin in the upper-left side.
    //   0 ------------ (+x)
    //   |
    //   |
    // (+y)
    bargraph.moveTo(0, maxBarH);    // we move to x = 0; y = the maximum height of a bar can have
    bargraph.lineTo(canvasW, maxBarH);    // be set to print the line (from the point above - where we moved - to the point Xabove=0 & Y=maximum bar height) with the width of the total canvas width
    bargraph.strokeStyle = "#000";    // we set the color to black
    bargraph.stroke();   // and we draw it!
}
 

 
// function drawBar
function drawBar(procentages, date, color) {
    // if number is equal or less than 100 (means equal or less than 100% draw the bar)
    if(procentages <= 100)
    {
        // we set the bar height back from % to pixels
        var barH = procentages * scaleH;
 
        // we set the fill color (dark gray)
        bargraph.fillStyle = color;
 
        // draw a filled rectangle 30 pixels wide with the given value
        bargraph.fillRect(offset, maxBarH - barH, barWidth, barH);  
        // horizontaly from the offset to 30; verticaly from maximum bar height - the bar height (this needs to remain white space) to the bar height
 
        // set the text color to black and write to the footer
        bargraph.fillStyle = '#000';
        bargraph.font = 'bold 15px arial,sans-serif';
        bargraph.fillText(date, offset + 5, maxBarH + 20, 26);    // we write the value to:
        //  horizontaly from offset+5 to 26; verticaly to maximum bar height + 20 to get the space between bars and text
 
        // horizontaly offset to the next bar
        // the width for a bar is 30px and the margins are 5px so we need to increment with 40
        offset += 40;
    }
}