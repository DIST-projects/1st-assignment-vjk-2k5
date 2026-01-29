from http.server import BaseHTTPRequestHandler, HTTPServer
import json

class RPCServer(BaseHTTPRequestHandler):
    """
    This class handles RPC-style HTTP requests.
    Each URL endpoint behaves like a remote procedure.
    """

    def do_POST(self):
        # Read request body
        length = int(self.headers['Content-Length'])
        data = json.loads(self.rfile.read(length))

        # Remote Procedure: Matrix Multiplication
        if self.path == "/matrix":
            A = data["A"]
            B = data["B"]

            result = [[0, 0], [0, 0]]
            for i in range(2):
                for j in range(2):
                    for k in range(2):
                        result[i][j] += A[i][k] * B[k][j]

        # Remote Procedure: Prime Number Calculation
        elif self.path == "/primes":
            n = data["n"]
            result = []
            for num in range(2, n + 1):
                for i in range(2, num):
                    if num % i == 0:
                        break
                else:
                    result.append(num)

        else:
            self.send_error(404)
            return

        # Send response back to client
        self.send_response(200)
        self.send_header("Content-Type", "application/json")
        self.end_headers()
        self.wfile.write(json.dumps({"result": result}).encode())


print("RPC Server running on Azure VM at port 8000")
HTTPServer(("", 8000), RPCServer).serve_forever()
