# ValidEasy Library

## Overview

Welcome to the ValidEasy Library, your one-stop solution for seamless and efficient user data validation in Android applications. Our library is designed to address common validation needs, making your development process faster and more reliable. Whether you're working on a small app or a large-scale project, ValidEasy Library provides the tools you need to ensure data integrity and enhance user experience.

![Снимок экрана 2024-07-14 в 22 18 34](https://github.com/user-attachments/assets/17f4b2e7-0893-4b9f-8652-c3a0aa541746)

## Features

### Email Validation
Effortlessly validate email addresses to ensure they adhere to standard email format, preventing invalid entries and ensuring reliable communication channels.

### Phone Number Validation
Validate phone numbers with support for various formats, including international numbers, making sure your application can handle global users with ease.

### Full Name Validation
Ensure names are correctly formatted with our full name validation, supporting standard naming conventions and reducing errors in user input.

### Age Validation
Check age formats and determine if the age is within a legal range. Ideal for applications requiring age verification, such as social media platforms or e-commerce sites.

### Password Strength Validation
Enhance security by validating password strength. Our library categorizes passwords into weak, medium, and strong, helping users create secure credentials.

### Date Validation
Verify date formats and ensure they conform to expected patterns. Perfect for applications handling events, bookings, or scheduling.

### Birth Date Validation
Validate birth dates to ensure they are realistic and meet minimum age requirements. Essential for applications with age restrictions or user profile management.

## Setup

### Step 1: Add JitPack Repository

To get started with the ValidEasy Library, add the JitPack repository to your root build.gradle file:

allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}

### Step 2: Add the Dependency

Next, add the ValidEasy Library dependency to your app-level build.gradle file:

dependencies {
  implementation 'com.github.yourusername:ValidEasyLibrary:1.0.0'
}

## Usage
Here are examples of how to use the ValidEasy Library in your Android application:

### Checking Phone Number Validity
```java
private static final String PHONE_REGEX = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$";

public static boolean checkPhoneNumber(String number) {
        return number.matches(PHONE_REGEX);
    }
```

## Getting Started

Integrating the ValidEasy Library into your Android project is a breeze. With just a few lines of code, you can start validating user input and ensuring data accuracy across your application. Say goodbye to common validation headaches and focus on building amazing features for your users.


## License

Copyright 2024 Kristina Kolesnyk

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

---

Thank you for choosing the Validate Library! We can't wait to see what you'll build with it. Happy coding!
