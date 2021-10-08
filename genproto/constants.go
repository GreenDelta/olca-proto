package main

// FileHeader is the file header that is written to the generated proto3 file.
// This is the place where you want to define global options
const FileHeader = `// Generated from olca-schema (https://github.com/GreenDelta/olca-schema).
// DO NOT EDIT!

syntax = "proto3";

package protolca;

option csharp_namespace = "ProtoLCA";
option go_package = ".;protolca";
option java_package = "org.openlca.proto";
option java_outer_classname = "Proto";
option java_multiple_files = true;


`

// BytesHint is a comment we add to fields with `bytes` as data type.
const BytesHint = `  // When we map to the bytes type it means that we have no matching message
  // type and just put the raw bytes into the field. This is specifically true
  // for our geometry data of locations which cannot be translated to valid
  // GeoJSON using Protocol Buffers (as they do not support arrays of arrays).
  // To indicate that this is a different field than the field in the
  // olca-schema definition, we append the _bytes suffix to the field name
`

const FileFooter = `

// We map the openLCA ModelType to this enumeration type because it is only
// used in the categories. In order to be compatible with the JSON-LD '@type'
// field we use the ProtoType enumeration type
enum ProtoCategoryType {

  UNDEFINED_CATEGORY_TYPE = 0;
  ACTOR = 1;
  CURRENCY = 3;
  DQ_SYSTEM = 4;
  FLOW = 5;
  FLOW_PROPERTY = 6;
  IMPACT_CATEGORY = 7;
  IMPACT_METHOD = 8;
  LOCATION = 9;
  PARAMETER = 11;
  PROCESS = 12;
  PRODUCT_SYSTEM = 13;
  PROJECT = 14;
  SOCIAL_INDICATOR = 15;
  SOURCE = 16;
  UNIT_GROUP = 18;
	RESULT = 19;
}

// This enumeration type is added for compatibility with the @type attribute of
// the openLCA JSON-LD format. In the proto messages we limit its usage to
// instances of CategorizedEntity and Ref while it is allowed for every type in
// the JSON-LD format. Thus, you should use ignoringUnknownFields flag when
// parsing openLCA JSON-LD messages with the generated proto parsers.
enum ProtoType {
  Undefined = 0;
  Actor = 1;
  Category = 2;
  Currency = 3;
  DQSystem = 4;
  Flow = 5;
  FlowProperty = 6;
  ImpactCategory = 7;
  ImpactMethod = 8;
  Location = 9;
  NwSet = 10;
  Parameter = 11;
  Process = 12;
  ProductSystem = 13;
  Project = 14;
	Result = 15;
  SocialIndicator = 16;
  Source = 17;
  Unit = 18;
  UnitGroup = 19;
}
`
