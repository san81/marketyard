 Ext.onReady(function(){
 
 var store = new Ext.data.Store({
        // load using script tags for cross domain, if the data in on the same domain as
        // this page, an HttpProxy would be better
        proxy: new Ext.data.HttpProxy({
            url: 'http://localhost:8080/marketyard/json/accountsList.action'
        }),

        // create reader that reads the Topic records
        reader: new Ext.data.JsonReader({
            root: 'accounts',
            totalProperty: 'totalCount',
            id:'accountId',
           fields:[
           		{name: 'accountId'},
           		{name: 'loginName'},
           		{name: 'password'},
           		{name: 'name'},
           		{name: 'mobile'},
				{name: 'address'},
				{name: 'village'},
				{name: 'regdate',type: 'date', dateFormat: 'timestamp'}
			]
		}),

     // turn on remote sorting
        remoteSort: true
    });
 	store.setDefaultSort('loginName');
 	
 	
 var cm = new Ext.grid.ColumnModel([{
           id: 'LoginName', // id assigned so we can apply custom css (e.g. .x-grid-col-topic b { color:#333 })
           header: "loginName",
           dataIndex: 'loginName',
           width: 100,
           renderer: renderTopic
           
        },{
           header: "Address",
           dataIndex: 'address',
           width: 100,
           hidden: true
        },{
           header: "mobile",
           dataIndex: 'mobile',
           width: 70,
           align: 'right'
        },{
           id: 'name',
           header: "Name",
           dataIndex: 'name',
           width: 60//,
          //renderer: renderLast
        }]);
 
 cm.defaultSortable = true;
 
  function renderTopic(value, p, record){
        return String.format(
                '<b><a href="http://extjs.com/forum/showthread.php?t={2}" target="_blank">{0}</a></b><a href="http://extjs.com/forum/forumdisplay.php?f={3}" target="_blank">{1} Forum</a>',
                value, record.data.forumtitle, record.id, record.data.forumid);
    }
 function renderLast(value, p, r){
        return String.format('{0}<br/>by {1}', value.dateFormat('M j, Y, g:i a'), r.data['lastposter']);
    }
    
    
  var grid = new Ext.grid.GridPanel({
        el:'topic-grid',
        width:700,
        height:500,
        title:'Accounts - Browse ',
        store: store,
        cm: cm,
        sm:new Ext.grid.RowSelectionModel({selectRow:Ext.emptyFn}),
       trackMouseOver:false,
        loadMask: true,  
          bbar: new Ext.PagingToolbar({
            pageSize: 2,
            store: store,
            displayInfo: true,
            displayMsg: 'Displaying topics {0} - {1} of {2}',
            emptyMsg: "No topics to display"
        })
    });
    
    
     grid.render();
   
    store.load({params:{start:0, limit:25}});  
    
});