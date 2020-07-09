import uuid

import protolca as proto
import google.protobuf.json_format as json

if __name__ == '__main__':
    flow = proto.Flow()
    flow.type = 'Flow'
    flow.id = str(uuid.uuid4())
    flow.name = 'steel'
    flow.flowType = proto.FlowType.PRODUCT_FLOW
    print(json.MessageToJson(flow))
