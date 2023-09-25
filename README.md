[![Actions Status](https://github.com/geoworo/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/geoworo/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/58a45cdbf453252a65f6/maintainability)](https://codeclimate.com/github/geoworo/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/58a45cdbf453252a65f6/test_coverage)](https://codeclimate.com/github/geoworo/java-project-78/test_coverage)

# Data Validator 
A tool that validates data in three formats: Strings, numbers and Maps.
Each schema has a number of methods. 

## Usage
The validator can be used as a library.

### Using as a library:
1. Download the files.
2. Create a **\*.jar** file by using the `make install` command.
3. Place the file into the same folder as your source code.
4. Import into your program.

### Example of usage:

```
Validator v = new Validator();
StringSchema str = v.string();

str.required().minLength(2).contains("tr").isValid("string"); // true

NumberSchema num = v.number();

num.required().positive().range(0, 10).isValid(-3); // false

MapSchema map = v.map();
Map<String, Object> schemas = new Hashmap<>();
schemas.put("name", v.sting().required());

Map<String, Object> example = new HashMap<>();
example.put("name", "Jane");
map.required().sizeOf(1).shape(schemas).isValid(example); // true
```
