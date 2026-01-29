import requests

# Azure VM Public IP
SERVER = "http://98.70.25.35:8000"

# ---- Remote Procedure Call: Matrix Multiplication ----
A = [[1, 2],
     [3, 4]]
B = [[5, 6],
     [7, 8]]

r1 = requests.post(
    SERVER + "/matrix",
    json={"A": A, "B": B}
)
print("Matrix Result:", r1.json()["result"])

# ---- Remote Procedure Call: Prime Numbers ----
r2 = requests.post(
    SERVER + "/primes",
    json={"n": 20}
)
print("Prime Numbers:", r2.json()["result"])
