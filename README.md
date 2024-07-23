# Search Engine

This is a simple search engine application implemented in Java. The application reads records from a file and allows users to search for records using different matching strategies.

## Table of Contents

- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Application Menu](#application-menu)
- [Architecture](#architecture)

## Getting Started

These instructions will help you set up and run the project on your local machine for development and testing purposes.

## Prerequisites

- Java Development Kit (JDK) 11 or higher
- Apache Maven 3.6.3 or higher

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/BrianVega/SearchEngine_Hyperskill.git
    ```
2. Navigate to the project directory:
    ```bash
    cd SearchEngine_Hyperskill
    ```
3. Build the project using Maven:
    ```bash
    mvn clean install
    ```

## Usage
1. [Load Data](#load-data).
2. [Application Menu](#application-menu).

### Load Data
1. Run the program by passing a CLI argument that corresponds to the name of the file in plain text format that will serve as input for load the data.
- 1.1 The CLI argument has the following syntax: **--data <*value*>** where value corresponds to the location where the input file is located.
- 1.2 The input file needs to meet the required input standards as shown in the [Sample Input File](#sample-input-file).    

#### Sample Input File
##### text.txt
Dwight Joseph djo@gmail.com  
Rene Webb webb@gmail.com  
Katie Jacobs  
Erick Harrington harrington@gmail.com  
Myrtle Medina  
Erick Burgess  
(...)  
_<*name*> <*surname*> <*email*>_

### Application Menu

The application presents a menu with the following options:

#### Find a person:
1. Select this option by entering `1`.
2. You will be prompted to choose a search strategy (ALL, ANY, NONE).
3. After selecting the strategy, enter the search term(s).
4. The application will display the records that match the search criteria based on the chosen strategy.

#### Print all people:
1. Select this option by entering `2`.
2. The application will display all the records currently loaded in the search engine.

#### Exit:
1. Select this option by entering `0`.
2. The application will exit.

### Search Strategies

You can search using three different strategies:

- **ALL**: Finds records containing all search terms.
- **ANY**: Finds records containing any of the search terms.
- **NONE**: Finds records that do not contain any of the search terms.

### Architecture

The project is structured as follows:

- **org.search**: Main package containing the core logic.
  - **Main**: Entry point of the application.
  - **SearchEngine**: Main class handling data loading and search operations.
  - **Data**: Class representing individual records.
  - **Enums**: Contains the `Strategies` enum defining search strategies.
  - **Interfaces**: Contains the `Strategy` interface and `BaseSearch` abstract class.
  - **Models.Strategies**: Contains implementations of the different search strategies (`All`, `Any`, `None`) and the `StrategyFactory` class.
  - **UI**: Handles user interactions.
  - **IO**: Handles input and output operations, including validation.
