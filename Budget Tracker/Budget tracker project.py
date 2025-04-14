import sqlite3

def init_db():
    conn = sqlite3.connect("budget.db")
    c = conn.cursor()
    c.execute('''CREATE TABLE IF NOT EXISTS transactions
                 (id INTEGER PRIMARY KEY, type TEXT, amount REAL, category TEXT, date TEXT)''')
    conn.commit()
    conn.close()

def add_transaction(t_type, amount, category, date):
    conn = sqlite3.connect("budget.db")
    c = conn.cursor()
    c.execute("INSERT INTO transactions (type, amount, category, date) VALUES (?, ?, ?, ?)",
              (t_type, amount, category, date))
    conn.commit()
    conn.close()

def view_summary():
    conn = sqlite3.connect("budget.db")
    c = conn.cursor()
    c.execute("SELECT type, SUM(amount) FROM transactions GROUP BY type")
    results = c.fetchall()
    for row in results:
        print(f"{row[0]}: {row[1]}")
    conn.close()

def main():
    init_db()
    while True:
        print("\\n1. Add Transaction\\n2. View Summary\\n3. Exit")
        choice = input("Choice: ")
        if choice == "1":
            t_type = input("Type (income/expense): ")
            amount = float(input("Amount: "))
            category = input("Category: ")
            date = input("Date (YYYY-MM-DD): ")
            add_transaction(t_type, amount, category, date)
        elif choice == "2":
            view_summary()
        elif choice == "3":
            break

if __name__ == "__main__":
    main()
