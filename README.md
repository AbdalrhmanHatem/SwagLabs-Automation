# 🧪 Swag Labs Web Automation

Automated test suite for [Swag Labs](https://www.saucedemo.com) using Java, Selenium WebDriver, TestNG, and Cucumber BDD framework.

---

## 🛠️ Tools & Technologies

| Tool | Version |
|------|---------|
| Java | 21 |
| Selenium WebDriver | 4.18.1 |
| TestNG | 7.9.0 |
| Cucumber | 7.15.0 |
| Maven | 3.x |
| Extent Reports | 5.1.1 |
| WebDriverManager | 5.7.0 |

---

## 📁 Project Structure
src
├── main/java/com/swaglabs/pages
│   ├── BasePage.java
│   ├── LoginPage.java
│   ├── ProductsPage.java
│   ├── CartPage.java
│   └── CheckoutPage.java
└── test
├── java/com/swaglabs
│   ├── hooks/Hooks.java
│   ├── hooks/ExtentReportManager.java
│   ├── runner/TestRunner.java
│   └── steps/StepDefinitions.java
└── resources/features
└── swagLabs.feature
---

## ⚙️ Setup Instructions

1. Clone the repository:
```bash
git clone https://github.com/YOUR_USERNAME/SwagLabs-Automation.git
```

2. Make sure you have:
    - Java JDK 21
    - Maven
    - Google Chrome

3. Install dependencies:
```bash
mvn clean install
```

---

## ▶️ How to Run

```bash
mvn test
```

Report will be generated at:
target/extent-reports/ExtentReport.html
---

## ✅ Test Cases

### Main Scenarios:
| TC | Description | Status |
|----|-------------|--------|
| TC01 | Login with valid credentials | ✅ Pass |
| TC02 | Add Backpack to cart | ✅ Pass |
| TC03 | Add Bolt T-Shirt to cart | ✅ Pass |
| TC04 | Verify total price | ✅ Pass |
| TC05 | Complete checkout | ✅ Pass |
| TC06 | Logout | ✅ Pass |

### Negative Scenarios (Bonus):
| TC | Description | Status |
|----|-------------|--------|
| TC07 | Invalid login credentials | ✅ Pass |
| TC08 | Locked out user | ✅ Pass |
| TC09 | Checkout with missing info | ✅ Pass |
| TC10 | Remove item from cart | ✅ Pass |

---

## 📊 Test Report

Open `target/extent-reports/ExtentReport.html` in any browser to view the detailed test report.

---

## 👤 Author

**Abdalrhman Hatem** — Mechatronics Engineering Student