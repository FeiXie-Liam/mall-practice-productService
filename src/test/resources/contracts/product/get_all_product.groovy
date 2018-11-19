import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method GET()
        url("/")
    }

    response {
        headers {
            contentType(applicationJsonUtf8())
        }
        body('''
            [{
                "id": 1,
                "name": "苹果",
                "price": 5, 
                "category": "水果",
                "brand": "红富士",
                "description": "甜",
                "productionDate": "2018-11-19",
                "productionPlace": "成都"
            }]
        ''')
        status(200)
    }
}