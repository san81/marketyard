function renderGrid(){
 
 var store = new Ext.data.Store({
        // load using script tags for cross domain, if the data in on the same domain as
        // this page, an HttpProxy would be better
        proxy: new Ext.data.MemoryProxy(ledgerJSON),
	
        // create reader that reads the Topic records
        reader: new Ext.data.JsonReader({
            root: 'transactions',
            totalProperty: 'totalCount',
            id:'transId',
           fields:[
           		{name: 'transId'},
           		{name: 'datetime'},
           		{name: 'description'},
           		{name: 'DR'},
           		{name: 'CR'},
           		{name: 'balance'},           		
				{name: 'mode'},
				{name: 'slipId'}
				//{name: 'regdate',type: 'date', dateFormat: 'timestamp'}
			]
		}),

     // turn on remote sorting
        remoteSort: false
    });
 	//store.setDefaultSort('datetime');
 	
 	
 var cm = new Ext.grid.ColumnModel([{
           
           header: "Date Time",
           dataIndex: 'datetime',
           width: 100,
           align: 'center'
           //renderer: renderLast
        },{
           header: "Description",
           dataIndex: 'description',
           width: 400,
           align: 'left',           
           renderer:renderDescription
        },{
           header: "DR",
           dataIndex: 'DR',
           width: 70,
           align: 'right',
           valign: 'center',
           renderer:renderAmount
        },{
           id: 'CR',
           header: "CR",
           dataIndex: 'CR',
           width: 70,
           align: 'right',
          renderer: renderAmount
        },{
           header: "Balance",
           dataIndex: 'balance',           
           width: 70,
           align: 'right',
          renderer: renderBalance
        },{
           header: "Payment Mode",
           dataIndex: 'mode',
           width: 80,
           align: 'center'
        },{
           header: "Bill ID",
           dataIndex: 'slipId',
           width: 90,
           align: 'center',
           renderer:renderSlipId
        }]);
 
 var myViewConfig = {
       

//      Return CSS class to apply to rows depending upon data values

        getRowClass: function(record, index) {
            var c = record.get('DR');
            if (index%2 == 0) {
                return 'altRow';
            } else  {
                return '';
            }
        }
    };
 
 cm.defaultSortable = true;
 
  function renderDescription(value, p, record){
        return String.format('<b>{0}<br><br></b>',value);
    }
 function renderAmount(value,p,r){
    	return String.format('<font color="blue"><b>{0}<b></font>',makeFormatedString(value));
    } 
 function renderSlipId(value,p,r){
    	return String.format('<a href="loadSlip_cancel.action?slipId={0}" target="_blank">{0}</a>',value);
    }
 function renderBalance(value,p,r){
	return String.format('<span class="gsumDisplay">{0}</span>',value);
  }    
 function renderMyDate(value,p,r){
    	return String.format('',value.dateFormat('M j, Y, g:i a'),r.data['datetime']);
    }
 function renderLast(value, p, r){
        return String.format('{0}', value.dateFormat('M j, Y, g:i a'), r.data['datetime']);
    }
    
    
  var grid = new Ext.grid.GridPanel({
        el:'ledger-grid',
        width:700,
        height:250,
        columnLines:true,
        title:accountHolder+'Ledger Details - Browse ',
        store: store,
        cm: cm,
        sm:new Ext.grid.RowSelectionModel({selectRow:Ext.emptyFn}),
       trackMouseOver:false,
        loadMask: true,
        viewConfig:myViewConfig
//          bbar: new Ext.PagingToolbar({
//            pageSize: 2,
//            store: store,
//            displayInfo: true,
//            displayMsg: 'Displaying Transactions {0} - {1} of {2}',
//            emptyMsg: "No Transactions to display"
//        })
    });
    
    
     grid.render();
   
    store.load({params:{start:0, limit:25}});  
    
}