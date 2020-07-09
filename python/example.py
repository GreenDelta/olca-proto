import uuid

import google.protobuf.json_format as json
import protolca.olca as proto

if __name__ == '__main__':
    ref = proto.Process()
    ref.id = str(uuid.uuid4())
    ref.name = 'steel'
    ref.description = 'some steel process'
    ref.version = '1.0.0'
    # print(json.MessageToJson(ref))
    print(ref.to_json('  '))
