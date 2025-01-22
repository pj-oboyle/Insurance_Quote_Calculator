# Insurance Quote Calculator

This project is a **refactored implementation** of an insurance quote calculator designed to determine a user's insurance quote based on their age and accident history. The application utilizes **JUnit testing** to validate functionality and edge cases. 

The system is designed to ensure a user-friendly experience while adhering to coding best practices. The project includes a **suite of unit tests** to ensure robustness and maintainability.

---

## Key Functionalities

### **Input Validation**
- Ensures user inputs are valid integers.
- Re-prompts for input in case of invalid or negative values.

### **Quote Calculation**
- Applies surcharges based on:
  - Age (additional fee for users aged 17–24).
  - Number of accidents (up to 5).
- Denies insurance for invalid scenarios:
  - Age below 17.
  - More than 5 accidents.

### **Unit Testing**
- Validates all methods in the project using edge cases and parameterized inputs.
- Ensures robustness and reliability of the quote calculation logic.

---

## Features

### **1. Refactored Codebase**
- The original code was refactored for:
  - Improved readability and maintainability.
  - Better adherence to object-oriented programming principles.
  - Enhanced modularity for easier testing and future feature expansion.

### **2. Insurance Quote Calculation**
- Based on user input, the application calculates the insurance quote by applying surcharges for:
  - Age: Users aged between 17 and 24 incur a surcharge of €100.
  - Accidents: Surcharges increase based on the number of accidents (up to 5).
- Quotes are denied for:
  - Users under 17 years old.
  - Users with more than 5 accidents.

### **3. JUnit Testing**
- Comprehensive test coverage includes:
  - Unit tests for the `Accident`, `Age`, and `Insurance` classes.
  - Handling of valid inputs, invalid inputs, and edge cases.
  - Parameterized tests to cover multiple scenarios.
- Key tests include:
  - Validating correct surcharge application for different user inputs.
  - Ensuring proper exception handling (e.g., `NullPointerException`, `ArrayIndexOutOfBoundsException`).
  - Simulating user input with `ByteArrayInputStream` for robust testing of `Insurance` class methods.

### **4. Test Suite**
- The project includes a centralized test suite (`TestSuite`) that runs tests for all classes:
  - `AccidentClassTests`
  - `AgeClassTests`
  - `InsuranceClassTest`

### **5. User Interaction**
- The program uses a **console-based interface** to:
  - Prompt the user for their age and accident history.
  - Display calculated quotes or reasons for denial.
- Input validation ensures that users cannot proceed without entering valid data.

### **6. Modular Design**
- The project is divided into classes to ensure separation of concerns:
  - `Accident`: Handles accident-related surcharges.
  - `Age`: Calculates age-related surcharges.
  - `Insurance`: Combines the logic of `Accident` and `Age` to calculate the final quote.
  - `Runner`: Contains the main method to execute the program.

---

### Original Code
The repository also contains a file named `OriginalCode.java` in the `original_code/` folder. This file represents the original codebase before the refactoring process. It is included to provide context for the changes made and highlight the improvements implemented in the refactored version.

---

## Technologies Used

- **Java**: Core programming language.
- **JUnit 5**: Testing framework for unit tests.
- **JUnit Platform**: For running the test suite.
- **Maven**: Build tool (optional for dependency management and running tests).

---

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/InsuranceQuoteCalculator.git
   ```

2. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).

3. Ensure the `JUnit` library is properly configured in your project dependencies.

4. Compile and run the `Runner` class to execute the program:
   ```bash
   javac Runner.java
   java ie.gmit.dip.Runner
   ```

---

## Usage

### **Running the Program**
1. Execute the `Runner` class.
2. Follow the prompts to:
   - Enter your age.
   - Enter the number of accidents you have had.
3. The program will calculate your insurance quote and display it in the console.

### **Running Tests**
1. Execute the `TestSuite` class to run all tests:
   ```bash
   javac TestSuite.java
   java ie.gmit.dip.TestSuite
   ```
2. Alternatively, run individual test classes (e.g., `AgeClassTests`, `AccidentClassTests`) for targeted testing.

---

## Future Improvements

1. **Graphical User Interface (GUI):**
   - Transition from a console-based interface to a user-friendly GUI.
   
2. **Database Integration:**
   - Store user quotes and history in a database for future reference.

3. **Advanced Features:**
   - Include options for different types of insurance policies.
   - Introduce discounts for loyal customers.

4. **Enhanced Input Validation:**
   - Incorporate regex patterns for stricter validation.

---

## License
This project is licensed under the GNU General Public License v3.0. See the [LICENSE](LICENSE) file for details.

---

## Contact

For questions or feedback, feel free to reach out:

- **Name**: pj-oboyle
- **GitHub**: [pj-oboyle](https://github.com/pj-oboyle)

---

Thank you for exploring this project! If you found it helpful, please give it a star on GitHub!
