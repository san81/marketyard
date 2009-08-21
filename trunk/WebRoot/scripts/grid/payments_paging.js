 Ext.onReady(function(){
 
 var store = new Ext.data.Store({
        // load using script tags for cross domain, if the data in on the same domain as
        // this page, an HttpProxy would be better
        proxy: new Ext.data.MemoryProxy(payments),
	
        // create reader that reads the Topic records
        reader: new Ext.data.JsonReader({
            root: 'payments',
            totalProperty: 'totalCount',
            id:'transId',
           fields:[
           		{name: 'transId'},
           		{name: 'datetime'},
           		{name: 'accountName'},
           		{name: 'amount'},
           		{name: 'flow'},
				{name: 'mode'},
				{name: 'slipId'}
				//{name: 'regdate',type: 'date', dateFormat: 'timestamp'}
			]
		}),

     // turn on remote sorting
        remoteSort: false
    });
 	store.setDefaultSort('accountName');
 	
 	
 var cm = new Ext.grid.ColumnModel([{
           id: 'transId', // id assigned so we can apply custom css (e.g. .x-grid-col-topic b { color:#333 })
           header: "Trans ID",
           dataIndex: 'transId',
           width: 100,
           align: 'center'
           //renderer: renderTopic
           
        },{
           
           header: "Date Time",
           dataIndex: 'datetime',
           width: 100,
           align: 'center'
           //renderer: renderLast
        },{
           header: "Supplier Name",
           dataIndex: 'accountName',
           width: 100,
           align: 'center'
        },{
           header: "Amount",
           dataIndex: 'amount',
           width: 70,
           align: 'center'
        },{
           id: 'flow',
           header: "Flow",
           dataIndex: 'flow',
           width: 70,
           align: 'center'
          //renderer: renderLast
        },{
           header: "Payment Mode",
           dataIndex: 'mode',
           width: 80,
           align: 'center'
        },{
           header: "Bill ID",
           dataIndex: 'slipId',
           width: 90,
           align: 'center'
        }]);
 
 cm.defaultSortable = true;
 
  function renderTopic(value, p, record){
        return String.format(
                '<b><a href="http://extjs.com/forum/showthread.php?t={2}" target="_blank">{0}</a></b><a href="http://extjs.com/forum/forumdisplay.php?f={3}" target="_blank">{1} Forum</a>',
                value, record.data.forumtitle, record.id, record.data.forumid);
    }
    function renderMyDate(value,p,r){
    	return String.format('',value.dateFormat('M j, Y, g:i a'),r.data['datetime']);
    }
 function renderLast(value, p, r){
        return String.format('{0}', value.dateFormat('M j, Y, g:i a'), r.data['datetime']);
    }
    
    
  var grid = new Ext.grid.GridPanel({
        el:'payments-grid',
        width:700,
        height:250,
        title:'Payments - Browse ',
        store: store,
        cm: cm,
        sm:new Ext.grid.RowSelectionModel({selectRow:Ext.emptyFn}),
       trackMouseOver:false,
        loadMask: true,  
          bbar: new Ext.PagingToolbar({
            pageSize: 2,
            store: store,
            displayInfo: true,
            displayMsg: 'Displaying payments {0} - {1} of {2}',
            emptyMsg: "No payments to display"
        })
    });
    
    
     grid.render();
   
    store.load({params:{start:0, limit:25}});  
    
});