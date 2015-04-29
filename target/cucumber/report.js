$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/screenshotfeature.feature");
formatter.feature({
  "id": "screenshot-step",
  "description": "      As a user I should able to take screenshot",
  "name": "Screenshot Step",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "screenshot-step;open-test-page",
  "description": "",
  "name": "Open test page",
  "keyword": "Scenario",
  "line": 4,
  "type": "scenario"
});
formatter.step({
  "name": "I navigate to \"http://selenium-cucumber.github.io/\"",
  "keyword": "Given ",
  "line": 5
});
formatter.match({
  "arguments": [
    {
      "val": "http://selenium-cucumber.github.io/",
      "offset": 15
    }
  ],
  "location": "PredefinedStepDefinitions.navigate_to(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "id": "screenshot-step;take-screenshot",
  "description": "",
  "name": "take screenshot",
  "keyword": "Scenario",
  "line": 7,
  "type": "scenario"
});
formatter.step({
  "name": "I take screenshot",
  "keyword": "Then ",
  "line": 8
});
formatter.match({
  "location": "PredefinedStepDefinitions.take_screenshot()"
});
formatter.result({
  "status": "skipped"
});
});