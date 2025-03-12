import csv
import sys

data = []

def load_data():

    data.clear()
    with open('Data/dataset.csv', newline='') as f:
        reader = csv.reader(f)
        for row in reader:
            data.append(row)

def get_cell(row, column):
    if row > len(data):
        raise IndexError("Row argument invalid")
    if column > len(data[0]):
        raise IndexError("Column argument invalid")
    return data[int(row)][int(column)]

def get_row_titles():
    row_titles = []
    for row in data:
        row_titles.append(row[0])

    return row_titles

def get_row_by_title(title):
    for row in data:
        if row[0] == title:
            return row
    return []

def get_silly():
    return 2

def main():
    load_data()
    if len(sys.argv) != 3:
        print("Usage: python3 basic_cl.py row column")
        sys.exit()
    try:
        row = int(sys.argv[1])
        column = int(sys.argv[2])
    except:
        print("Usage: python3 basic_cl.py row column")
        sys.exit()
    if 0 <= row <= 3 and 0 <= column <= 3:
        print(get_cell(row, column))
    else:
        print("Usage: python3 basic_cl.py row column")

if __name__=='__main__':
    main()