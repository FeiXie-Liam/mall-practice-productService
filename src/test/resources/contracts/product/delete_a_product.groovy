package product

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method DELETE()
        url("/1")
    }

    response {
        status(204)
    }
}