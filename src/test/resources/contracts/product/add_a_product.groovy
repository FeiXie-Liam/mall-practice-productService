import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method POST()
        url("/")
        headers {
            contentType(applicationJsonUtf8())
        }
        body('''
            {
                "name": "香蕉",
                "price": 4, 
                "category": "水果",
                "brand": "未知",
                "description": "甜",
                "productionDate": "2018-11-19",
                "productionPlace": "成都"
            }
        ''')
    }

    response {
        status(204)
    }
}