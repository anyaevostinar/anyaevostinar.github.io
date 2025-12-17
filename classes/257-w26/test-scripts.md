---
layout: page
title: Test scripts
permalink: /classes/257-w26/test-scripts
---

This is a page that just holds the various commands for tests for the Git Classroom assignments for this class. 

## Run test suite
### Setup command:
```
python -m pip install --upgrade pip; pip install flask; pip install psycopg2; pip install records; curl -o ProductionCode/psql_config.py https://anyaevostinar.github.io/classes/257-s25/psql_config.py
```

### Run command:
```
python3 -m unittest discover -s Tests
```

## Coverage report
### Setup command:
```
python -m pip install --upgrade pip; pip install coverage; pip install flask; pip install psycopg2; pip install records; curl -o ProductionCode/psql_config.py https://anyaevostinar.github.io/classes/257-s25/psql_config.py
```

### Run command:
```
python3 -m coverage run --source ProductionCode,flask_app,command_line -m unittest discover Tests; python3 -m coverage report -m
```

## Style check- ProductionCode
### Setup command:
```
python -m pip install --upgrade pip; pip install pylint; curl -o ProductionCode/psql_config.py https://anyaevostinar.github.io/classes/257-s25/psql_config.py
```

### Run command:
```
pylint --disable=import-error,too-few-public-methods ProductionCode
```
## Style check Tests:
```
pylint --disable=import-error,too-few-public-methods Tests
```
### command line:
```
pylint --disable=import-error,too-few-public-methods command_line.py
```

### flask app:
```
pylint --disable=import-error,too-few-public-methods flask_app.py
```

TODO:
* Figure out better database mocking?
* Something with front end?

```bash
curl -o ProductionCode/basic_cl.py https://anyaevostinar.github.io/classes/Summer-21/basic_cl.py
```

To reset a database password
```sql
alter user teamx with password newpassword;
```
