## First try
```
/* make a population of circles */
var population = [];
for (var i = 0; i < 100; i++) {
  var circle = document.createElement('div');
  circle.style.width = '10px';
  circle.style.height = '10px';
  circle.style.borderRadius = '50%';
  circle.style.backgroundColor = 'black';
  circle.style.position = 'absolute';
  circle.style.left = Math.random() * window.innerWidth + 'px';
  circle.style.top = Math.random() * window.innerHeight + 'px';
  document.body.appendChild(circle);
  population.push(circle);
}

/* Make each circle move */
var move = function() {
  for (var i = 0; i < population.length; i++) {
    var circle = population[i];
    circle.style.left = (parseInt(circle.style.left) + Math.random() * 10 - 5) + 'px';
    circle.style.top = (parseInt(circle.style.top) + Math.random() * 10 - 5) + 'px';
  }
};

/* move them again */
setInterval(move, 100);

/* Give each circle a variable for movement */
for (var i = 0; i < population.length; i++) {
  var circle = population[i];
  circle.moveX = Math.random() * 10 - 5;
  circle.moveY = Math.random() * 10 - 5;
}

/* Give each circle a variable for points */
for (var i = 0; i < population.length; i++) {
  var circle = population[i];
  circle.points = 0;
}

/* If one circle runs into another circle, subtract a point from both */
var collision = function(circle1, circle2) {
  var distance = Math.sqrt(Math.pow(circle1.offsetLeft - circle2.offsetLeft, 2) + Math.pow(circle1.offsetTop - circle2.offsetTop, 2));
  if (distance < circle1.offsetWidth / 2 + circle2.offsetWidth / 2) {
    circle1.points--;
    circle2.points--;
  }
};

/* Every second, give each circle a point */
var addPoints = function() {
  for (var i = 0; i < population.length; i++) {
    var circle = population[i];
    circle.points++;
  }
};

/* If a circle has zero points, remove it */
var removeZeroPoints = function() {
  for (var i = 0; i < population.length; i++) {
    var circle = population[i];
    if (circle.points === 0) {
      document.body.removeChild(circle);
      population.splice(i, 1);
    }
  }
};

/* If a circle has 50 points, make a copy of it */
var addCopies = function() {
  for (var i = 0; i < population.length; i++) {
    var circle = population[i];
    if (circle.points === 50) {
      var newCircle = circle.cloneNode(true);
      newCircle.style.left = Math.random() * window.innerWidth + 'px';
      newCircle.style.top = Math.random() * window.innerHeight + 'px';
      document.body.appendChild(newCircle);
      population.push(newCircle);
    }
  }
};

/* Display the points of each circle */
var displayPoints = function() {
  for (var i = 0; i < population.length; i++) {
    var circle = population[i];
    var pointsDisplay = document.createElement('div');
    pointsDisplay.innerHTML = circle.points;
    pointsDisplay.style.position = 'absolute';
    pointsDisplay.style.left = circle.offsetLeft + 'px';
    pointsDisplay.style.top = circle.offsetTop + 'px';
    document.body.appendChild(pointsDisplay);
  }
};

/* Show the points */
setInterval(displayPoints, 100);

/* hide the points */
setInterval(removeZeroPoints, 100);

/* clear the screen */
setInterval(function() {
  while (document.body.firstChild) {
    document.body.removeChild(document.body.firstChild);
  }
}, 1000);
```