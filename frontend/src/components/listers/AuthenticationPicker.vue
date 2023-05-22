<template>
    <div>
        <v-card-title @click="openDialog" style="cursor: pointer;">
            Authentication : 
        </v-card-title>

        <v-dialog v-model="pickerDialog">
            <v-card>
                <v-card-title>Authentication</v-card-title>
                <v-card-text>
                    <v-list two-line v-if="list.length > 0">
                        <v-list-item-group 
                                v-model="selected" 
                                color="indigo"
                                @change="select"
                        >
                            <v-list-item v-for="(item, idx) in list" :key="idx">
                                <template v-slot:default="{ active }">
                                    <v-list-item-avatar color="grey darken-1">
                                    </v-list-item-avatar>
                                    
                                    <v-list-item-content>
                                        <v-list-item-title>
                                        </v-list-item-title>
                                        <v-list-item-subtitle>
                                            UserId :  {{item.userId }}
                                        </v-list-item-subtitle>
                                        <v-list-item-subtitle>
                                            Username :  {{item.username }}
                                        </v-list-item-subtitle>
                                        <v-list-item-subtitle>
                                            Password :  {{item.password }}
                                        </v-list-item-subtitle>
                                    </v-list-item-content>

                                    <v-list-item-action>
                                        <v-checkbox :input-value="active" color="indigo"></v-checkbox>
                                    </v-list-item-action>
                                </template>
                            </v-list-item>
                        </v-list-item-group>
                    </v-list>
                </v-card-text>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="deep-purple lighten-2" text @click="pickerDialog = false">Close</v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>
    </div>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'AuthenticationPicker',
        props: {
            value: [String, Object, Array, Number, Boolean],
            editMode: Boolean,
        },
        data: () => ({
            list: [],
            selected: null,
            referenceValue: null,
            pickerDialog: false,
        }),
        async created() {
            var me = this;
            var temp = await axios.get(axios.fixUrl('/authentications'))
            if(temp.data) {
                me.list = temp.data._embedded.authentications;
            }

            if(me.value && typeof me.value == "object" && Object.values(me.value)[0]) {
                var idKey = 'userId'
                
                
                var id = me.value[idKey];
                var tmpValue = await axios.get(axios.fixUrl('/authentications/' + id))
                if(tmpValue.data) {
                    var val = tmpValue.data
                    
                    
                    
                    me.referenceValue = val
                }
            }
        },
        methods: {
            openDialog() {
                if (this.editMode) {
                    this.pickerDialog = true
                } else {
                    var idKey = 'userId'
                    
                    
                    var id = this.value[idKey];
                    var path = '/authentications/';
                    this.$router.push(path + id);
                }
            },
            select(val) {
                var obj = {}
                if(val != undefined) {
                    var arr = this.list[val]._links.self.href.split('/');
                    obj['userId'] = arr[4]; 
                    
                    
                    this.$emit('selected', obj);
                    this.referenceValue = this.list[val];
                }
            },
        },
    };
</script>

