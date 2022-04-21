package uk.gov.hmrc.test.ui.specs

import uk.gov.hmrc.test.ui.pages.{ExamplePage, PayOnlinePage}
import uk.gov.hmrc.test.ui.spec.BaseSpec
import uk.gov.hmrc.test.ui.specs.tags.ZapTests

import scala.xml.NodeSeq.Empty.text

class ExampleSpec extends BaseSpec {

  info("Example Spec using ScalaTest")

  Feature("User accessing payments page") {

    Scenario("A logged in user is able to access payment details page", ZapTests) { //Remove ZapTests tag if not required

      Given("A logged in user accesses payments page")

      go to ExamplePage
      pageTitle shouldBe ExamplePage.title
      ExamplePage.login(PayOnlinePage.url)

      eventually {
     pageTitle shouldBe PayOnlinePage.title
      }

      When("User chooses to pay VAT tax")
      click on radioButton("tax_to_pay-2")
      click on "next"
      eventually {
        pageTitle shouldBe "What is your VAT registration number? - Pay your VAT - GOV.UK"
      }

      Then("User enter the VAT registration number")
      text.equals("123456781")
      click on "next"
      tagName("h1").element.text shouldBe "What is your VAT registration number?"
    }
  }
}
