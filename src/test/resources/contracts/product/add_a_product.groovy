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

        bodyMatchers {
            jsonPath('$.name', byRegex("^[\\u4e00-\\u9fa5_a-zA-Z0-9]+\$"))
            jsonPath('$.price', byRegex(number()))
            jsonPath('$.category', byRegex("^[\\u4e00-\\u9fa5_a-zA-Z0-9]+\$"))
            jsonPath('$.brand', byRegex("^[\\u4e00-\\u9fa5_a-zA-Z0-9]+\$"))
            jsonPath('$.description', byRegex("^[\\u4e00-\\u9fa5_a-zA-Z0-9]+\$"))
            jsonPath('$.productionDate', byRegex(isoDate()))
            jsonPath('$.productionPlace', byRegex("^[\\u4e00-\\u9fa5_a-zA-Z0-9]+\$"))
        }
    }

    response {
        status(204)
    }
}