package product

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method DELETE()
        url value(producer("/1"), consumer(regex("/\\d+")))
    }

    response {
        status(204)
    }
}