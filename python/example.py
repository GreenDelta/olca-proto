import uuid

import google.protobuf.json_format as json
import protolca as proto

if __name__ == '__main__':
    ref = proto.Process()
    ref.id = str(uuid.uuid4())
    ref.name = 'steel'
    ref.description = 'some steel process'
    print(json.MessageToJson(ref))
