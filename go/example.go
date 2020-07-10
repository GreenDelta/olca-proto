package main

import (
	"fmt"
	proto "main/protolca"

	"github.com/google/uuid"
	"google.golang.org/protobuf/encoding/protojson"
)

func main() {
	id, _ := uuid.NewRandom()
	flow := &proto.Flow{
		Type:     "Flow",
		Id:       id.String(),
		Name:     "Steel",
		FlowType: proto.FlowType_PRODUCT_FLOW,
	}
	json := protojson.Format(flow)
	fmt.Println(string(json))
}
