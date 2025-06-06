---
layout: page
title: Test scripts
permalink: /classes/257-s25/test-scripts
---

This is a page that just holds the various commands for tests for the Git Classroom assignments for this class. 

Run test suite
Setup command:
```
python -m pip install --upgrade pip; pip install flask; pip install psycopg2; curl -o ProductionCode/psql_config.py https://anyaevostinar.github.io/classes/257-s25/psql_config.py; curl -o ProductionCode/psqlConfig.py https://anyaevostinar.github.io/classes/257-s25/psqlConfig.py
```

Run command:
```
python3 -m unittest discover -s Tests
```

Coverage report
Setup command:
```
python -m pip install --upgrade pip; pip install coverage; pip install flask; pip install psycopg2; curl -o ProductionCode/psql_config.py https://anyaevostinar.github.io/classes/257-s25/psql_config.py; curl -o ProductionCode/psqlConfig.py https://anyaevostinar.github.io/classes/257-s25/psqlConfig.py
```

Run command:
```
python3 -m coverage run --source ProductionCode,app,cl -m unittest discover Tests; python3 -m coverage report -m
```

Style check- ProductionCode
Setup command:
```
python -m pip install --upgrade pip; pip install pylint; curl -o ProductionCode/psql_config.py https://anyaevostinar.github.io/classes/257-s25/psql_config.py; curl -o ProductionCode/psqlConfig.py https://anyaevostinar.github.io/classes/257-s25/psqlConfig.py
```

Run command:
```
pylint --disable=import-error ProductionCode
```
Tests:
```
pylint --disable=import-error Tests
```
cl:
```
pylint --disable=import-error cl.py
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
