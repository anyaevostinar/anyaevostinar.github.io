---
layout: page
title: Research
permalink: /Research/
---

My research is at the intersection of evolutionary biology and computer science. 
I am currently focused on two main categories within that intersection: 
1. studying the evolution of symbiosis by maintaining and using my digital evolution library Symbulation and
2. using digital evolution to create educational games by modifying existing games and gamifying Symbulation's graphical user interface. 

See my [Google Scholar](https://scholar.google.com/citations?user=7ZwlPwsAAAAJ) profile for my publications and an overview of my main projects below.

<p style="text-align: center;"><a href="/research/undergrad"><button style="background-color:#4B0082;border-radius: 8px;font-size: 24px;border: none;color: white;padding: 15px 32px;text-align: center;" type="button">Joining the Lab</button></a> </p>

<h2 style="text-align: center;">Projects</h2>

<style>
* {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Float four columns side by side */
.column {
  float: left;
  width: 50%;
  padding: 0 10px;
}

/* Remove extra left and right margins, due to padding in columns */
.row {margin: 0 -5px;}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Style the counter cards */
.card {
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  width: 100%;
}

.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}

.container {
  padding: 2px 16px;
}

.column a:hover {
  text-decoration: none;
  color: black;
}

.column a:link {
  text-decoration: none;
  color: black;
}

.column a:visited {
  text-decoration: none;
  color: black;
}

.column a:active {
  text-decoration: none;
  color: black;
}

/* Responsive columns - one column layout (vertical) on small screens */
@media screen and (max-width: 600px) {
  .column {
    width: 100%;
    display: block;
    margin-bottom: 20px;
  }
}
</style>

<div class="row">
  <div class="column">
    <a href="https://symbulation.readthedocs.io/en/latest/"><div class="card">
    <img src="/images/mutualismgraphic.png" alt="A diagram of the Symbulation software default configuration." style="width:100%">
        <div class="container">
            <h4><b>Symbulation</b></h4>
            <p>Symbulation is the first digital evolution library specifically suited for studying the evolution of symbiosis. It can be used to study the effect of many different factors on the evolution of parasitism or mutualism of symbionts.</p>
        </div>
    </div></a>
    <a href="https://direct.mit.edu/artl/article/24/4/229/2907/Spatial-Structure-Can-Decrease-Symbiotic"><div class="card">
    <img src="/images/VertTransResults.png" alt="Two box plots, the one on the left is labeled Fully Structured and is signifcantly lower than the one on the right, which is labeled No Structure. On the top is the label 60%." style="width:100%">
        <div class="container">
            <h4><b>Evolution of Mutualism</b></h4>
            <p>Using Symbulation, we verified that increased vertical transmission rate selects for mutualism. However, spatial structure does not strictly increase selection for mutualism; at intermediate vertical transmission rates, spatial structure selected against mutualism to the point of parasitism evolving instead.</p>
        </div>
    </div></a>
  </div>
  <div class="column">
    <a href="https://anyaevostinar.github.io/SymbulationEmp/web/symbulation.html"><div class="card">
    <img src="/images/SymbulationGUI.png" alt="A grid of squares and circles inside some of the squares." style="width:100%">
        <div class="container">
            <h4><b>Symbulation GUI</b></h4>
            <p>Symbulation has a browser-based GUI that runs the full research software in the browser, enabling education and outreach projects.</p>
        </div>
      </div></a>
      <a href="https://arxiv.org/abs/2007.03787"><div class="card">
        <img src="/images/RealisticFishing.png" alt="A screenshot from the game Stardew Valley with pixel graphics, showing a human character fishing." style="width:100%">
        <div class="container">
            <h4><b>RealisticFishing in Stardew Valley</b></h4>
            <p>We modified the farming simulation game Stardew Valley to include evolutionary dynamics for the fish populations. Players were incentivized to keep the largest fish, however that leads to evolutionary pressure on the fish population to be smaller in adulthood.</p>
        </div>
       </div></a>
    </div>
</div>