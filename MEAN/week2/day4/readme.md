# Week 2 Day 4

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/AngularJS_logo.svg/2000px-AngularJS_logo.svg.png" alt="AngularJS logo" width="600px">

## Angular

* Architecture
* Nesting Components
* Inputs, and Outputs

## Learning Objectives:
* Angular Architecture - Data is stored in the components, not services.
* How to properly nest Components.
* When to use Inputs and Outputs.

## Lecture Questions:
<details><summary>How high level do we need data to be?</summary>

	As high as needed, to cover all child components that may need that data relatively often.
</details>
<details><summary>When we need a child component to have data, why would we use Input over an API call?<summary>
</details>
<details><summary>Why use Output and how it can benefit us?</summary>
</details>
<details><summary>Where should we be storing data that we want multiple components to use?</summary>

	At the highest level component needed but more relevant.
</details>
<details><summary>How do we nest Components, what is the syntax?</summary>

	<app-componentName></app-componentName>
</details>
<details><summary>We are currently using one App Module, but can we use multiple modules, and if so, why would we consider doing so?</summary>
	
Separating the application, similar to namespaces, usually different modules are not relevant to each other in data/usage.
</details>
