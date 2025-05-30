from http.server import BaseHTTPRequestHandler, HTTPServer
import requests
import logging

class ProxyHandler(BaseHTTPRequestHandler):
    def do_GET(self):
        backend_url = f"http://localhost:8090{self.path}"
        logging.info("Forwarding GET request to %s", backend_url)
        response = requests.get(backend_url)

        self.send_response(response.status_code)
        for key, value in response.headers.items():
            if key.lower() == "transfer-encoding":
                continue  # skip unsupported headers
            self.send_header(key, value)
        self.end_headers()
        self.wfile.write(response.content)

    def do_POST(self):
        content_length = int(self.headers.get("Content-Length", 0))
        post_data = self.rfile.read(content_length)
        backend_url = f"http://localhost:8090{self.path}"
        logging.info("Forwarding POST request to %s", backend_url)
        response = requests.post(backend_url, data=post_data, headers={key: val for key, val in self.headers.items()})

        self.send_response(response.status_code)
        for key, value in response.headers.items():
            if key.lower() == "transfer-encoding":
                continue
            self.send_header(key, value)
        self.end_headers()
        self.wfile.write(response.content)

# Setup logging
logging.basicConfig(level=logging.INFO)
server_address = ('localhost', 8090)
httpd = HTTPServer(server_address, ProxyHandler)
logging.info("Proxy running on http://localhost:8090")
httpd.serve_forever()
