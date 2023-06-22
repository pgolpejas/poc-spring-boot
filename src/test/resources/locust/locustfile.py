from random import randint

from locust import HttpUser, task

######################################################################################
# Manual installation: https://docs.locust.io/en/stable/installation.html
# Run with: locust -H http://localhost:8080
# if locust command not found: add locust installation path to PATH environment
######################################################################################

######################################################################################
# Running in Docker
# docker run -p 8089:8089 -v $PWD:/mnt/locust locustio/locust -f /mnt/locust/locustfile.py
# if you need another instance to test on another port
# docker run -p 8090:8089 -v $PWD:/mnt/locust locustio/locust -f /mnt/locust/locustfile.py
######################################################################################

# Open: http://localhost:8089/ or http://localhost:8090/ (if you have two instances)

headers = {
    "Accept": "application/json",
    "Content-Type": "application/json",
}

search1_json = {
                "searchDate": "2020-06-14T10:00:00.000Z",
                "productId": 35455,
                "brandId": 1
              }

search2_json = {
                "searchDate": "2020-06-14T16:00:00.000Z",
                "productId": 35455,
                "brandId": 1
              }

search3_json = {
                "searchDate": "2020-06-14T21:00:00.000Z",
                "productId": 35455,
                "brandId": 1
              }

search4_json = {
                "searchDate": "2020-06-15T10:00:00.000Z",
                "productId": 35455,
                "brandId": 1
              }

search5_json = {
                "searchDate": "2020-06-16T21:00:00.000Z",
                "productId": 35455,
                "brandId": 1
              }

class QuickStartUser(HttpUser):

    @task(1)
    def launch_search1(self):
        response = self.client.post("/prices/1.0/search", json = search1_json)
        print(response.text)

    @task(2)
    def launch_search2(self):
        response = self.client.post("/prices/1.0/search", json = search2_json)
        print(response.text)

    @task(3)
    def launch_search3(self):
        response = self.client.post("/prices/1.0/search", json = search3_json)
        print(response.text)

    @task(4)
    def launch_search4(self):
        response = self.client.post("/prices/1.0/search", json = search4_json)
        print(response.text)

    @task(5)
    def launch_search5(self):
        response = self.client.post("/prices/1.0/search", json = search5_json)
        print(response.text)






