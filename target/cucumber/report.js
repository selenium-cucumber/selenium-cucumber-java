$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/featuretest.feature");
formatter.feature({
  "id": "each-step-for-testing",
  "description": "      As a user I should able to verify all steps are working",
  "name": "Each step for testing",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "each-step-for-testing;open-test-page",
  "description": "",
  "name": "Open test page",
  "keyword": "Scenario",
  "line": 4,
  "type": "scenario"
});
formatter.step({
  "name": "I navigate to \"file:\\\\\\D:\\sc_ruby\\selenium-cucumber-ruby\\tests\\test_page.html\"",
  "keyword": "Given ",
  "line": 5
});
formatter.step({
  "name": "I switch to frame having name or id \"one\"",
  "keyword": "Then ",
  "line": 7
});
formatter.step({
  "name": "element having id \"name\" should be present",
  "keyword": "Then ",
  "line": 8
});
formatter.step({
  "name": "I switch to default content",
  "keyword": "Then ",
  "line": 10
});
formatter.step({
  "name": "I switch to frame having xpath \"//iframe[@name\u003d\u0027two\u0027]\"",
  "keyword": "Then ",
  "line": 12
});
formatter.step({
  "name": "element having id \"email\" should be present",
  "keyword": "Then ",
  "line": 13
});
formatter.step({
  "name": "I switch to default content",
  "keyword": "Then ",
  "line": 15
});
formatter.step({
  "name": "element having xpath \"//iframe[@name\u003d\u0027one\u0027]\" should be present",
  "keyword": "Then ",
  "line": 16
});
formatter.match({
  "arguments": [
    {
      "val": "file:\\\\\\D:\\sc_ruby\\selenium-cucumber-ruby\\tests\\test_page.html",
      "offset": 15
    }
  ],
  "location": "PredefinedStepDefinitions.navigate_to(String)"
});
formatter.result({
  "duration": 6246878314,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "name or id",
      "offset": 25
    },
    {
      "val": "one",
      "offset": 37
    }
  ],
  "location": "PredefinedStepDefinitions.switch_frame_by_element(String,String)"
});
formatter.result({
  "duration": 48759567,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "id",
      "offset": 15
    },
    {
      "val": "name",
      "offset": 19
    },
    {
      "val": "",
      "offset": 31
    }
  ],
  "location": "PredefinedStepDefinitions.check_element_presence(String,String,String)"
});
formatter.result({
  "duration": 106212271,
  "status": "passed"
});
formatter.match({
  "location": "PredefinedStepDefinitions.switch_to_default_content()"
});
formatter.result({
  "duration": 38255152,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "xpath",
      "offset": 25
    },
    {
      "val": "//iframe[@name\u003d\u0027two\u0027]",
      "offset": 32
    }
  ],
  "location": "PredefinedStepDefinitions.switch_frame_by_element(String,String)"
});
formatter.result({
  "duration": 70385425,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "id",
      "offset": 15
    },
    {
      "val": "email",
      "offset": 19
    },
    {
      "val": "",
      "offset": 32
    }
  ],
  "location": "PredefinedStepDefinitions.check_element_presence(String,String,String)"
});
formatter.result({
  "duration": 73114470,
  "status": "passed"
});
formatter.match({
  "location": "PredefinedStepDefinitions.switch_to_default_content()"
});
formatter.result({
  "duration": 35126781,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "xpath",
      "offset": 15
    },
    {
      "val": "//iframe[@name\u003d\u0027one\u0027]",
      "offset": 22
    },
    {
      "val": "",
      "offset": 51
    }
  ],
  "location": "PredefinedStepDefinitions.check_element_presence(String,String,String)"
});
formatter.result({
  "duration": 80743979,
  "status": "passed"
});
});