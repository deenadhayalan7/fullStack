import { Progress } from 'rsuite';
import './Dashboard.css';
const Dashboard =()=>{ 
  const style = {
    width: 120,
    display: 'inline-block',
    marginRight: 10
  };
    return(
       
        <>

        <>
  <link
    href="https://fonts.googleapis.com/css?family=DM+Sans:400,500,700&display=swap"
    rel="stylesheet"
  />
  <div className="task-manager">
    <div className="left-bar">
      <div className="upper-part">
        <div className="actions">
          <div className="circle" />
          <div className="circle-2" />
        </div>
      </div>
      <div className="left-content">
        <ul className="action-list">
          <li className="item">
            
            <span style={{fontSize:"23px"}}>COURSES</span>
          </li>
          <br></br>
          <li className="item">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width={24}
              height={24}
              viewBox="0 0 24 24"
              fill="none"
              stroke="currentColor"
              strokeWidth={2}
              strokeLinecap="round"
              strokeLinejoin="round"
              className="feather feather-star"
            >
              <polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2" />
            </svg>
            <span> Enrolled</span>
            <br></br> <br></br>
          </li>
          <li className="item">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width={24}
              height={24}
              viewBox="0 0 24 24"
              fill="none"
              stroke="currentColor"
              strokeWidth={2}
              strokeLinecap="round"
              strokeLinejoin="round"
              className="feather feather-hash"
            >
              <line x1={4} y1={9} x2={20} y2={9} />
              <line x1={4} y1={15} x2={20} y2={15} />
              <line x1={10} y1={3} x2={8} y2={21} />
              <line x1={16} y1={3} x2={14} y2={21} />
            </svg>
            <span>Unrolled</span>
            <br></br> <br></br>
          </li>
          <li className="item">
          <li className="item">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width={24}
              height={24}
              fill="none"
              stroke="currentColor"
              strokeLinecap="round"
              strokeLinejoin="round"
              strokeWidth={2}
              className="feather feather-calendar"
              viewBox="0 0 24 24"
            >
              <rect width={18} height={18} x={3} y={4} rx={2} ry={2} />
              <path d="M16 2v4M8 2v4m-5 4h18" />
            </svg>
            <span>Upcoming</span>
            <br></br> <br></br>
          </li>
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width={24}
              height={24}
              viewBox="0 0 24 24"
              fill="none"
              stroke="currentColor"
              strokeWidth={2}
              strokeLinecap="round"
              strokeLinejoin="round"
              className="feather feather-users"
            >
              <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2" />
              <circle cx={9} cy={7} r={4} />
              <path d="M23 21v-2a4 4 0 0 0-3-3.87" />
              <path d="M16 3.13a4 4 0 0 1 0 7.75" />
            </svg>
            <span>Institution</span>
            <br></br> <br></br>
          </li>
          <li className="item">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width={24}
              height={24}
              fill="none"
              stroke="currentColor"
              strokeLinecap="round"
              strokeLinejoin="round"
              strokeWidth={2}
              className="feather feather-trash"
              viewBox="0 0 24 24"
            >
              <path d="M3 6h18m-2 0v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2" />
            </svg>
            <span>Trash</span>
          </li>
        </ul>
       
      </div>
    </div>
    <div className="page-content">
      <div className="header">DASHBOARD</div>
      <div className="content-categories">
        <div className="label-wrapper">
          <input className="nav-item" name="nav" type="radio" id="opt-1" />
          <label className="category" htmlFor="opt-1">
            All
          </label>
        </div>
        <div className="label-wrapper">
          <input
            className="nav-item"
            name="nav"
            type="radio"
            id="opt-2"
            defaultChecked=""
          />
          <label className="category" htmlFor="opt-2">
            Important
          </label>
        </div>
        <div className="label-wrapper">
          <input className="nav-item" name="nav" type="radio" id="opt-3" />
          <label className="category" htmlFor="opt-3">
            Notes
          </label>
        </div>
        <div className="label-wrapper">
          <input className="nav-item" name="nav" type="radio" id="opt-4" />
          <label className="category" htmlFor="opt-4">
            Links
          </label>
        </div>
      </div>
    
        <div className="task-box red">
          <div className="description-task">
            <div className="task-name">INSTITUTION</div>
          </div>
          <div className="more-button" />
          <div className="members">
            <img
              src="https://images.unsplash.com/photo-1491349174775-aaafddd81942?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=934&q=80"
              alt="member"
            />
            <img
              src="https://images.unsplash.com/photo-1475552113915-6fcb52652ba2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1934&q=80"
              alt="member-2"
            />
            <img
              src="https://images.unsplash.com/photo-1493752603190-08d8b5d1781d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1600&q=80"
              alt="member-3"
            />
            <img
              src="https://images.unsplash.com/photo-1484688493527-670f98f9b195?ixlib=rb-1.2.1&auto=format&fit=crop&w=2230&q=80"
              alt="member-4"
            />
          </div>
        </div>
        <div className="task-box green">
          <div className="description-task">
            <div className="task-name">ENROLLED COURSES</div>
          </div>
          <div className="more-button" />
          <div className="members">
            <img
              src="https://images.unsplash.com/photo-1523419409543-a5e549c1faa8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=943&q=80"
              alt="member"
            />
            <img
              src="https://images.unsplash.com/photo-1519742866993-66d3cfef4bbd?ixlib=rb-1.2.1&auto=format&fit=crop&w=881&q=80"
              alt="member-2"
            />
            <img
              src="https://images.unsplash.com/photo-1521122872341-065792fb2fa0?ixlib=rb-1.2.1&auto=format&fit=crop&w=2208&q=80"
              alt="member-3"
            />
            <img
              src="https://images.unsplash.com/photo-1486302913014-862923f5fd48?ixlib=rb-1.2.1&auto=format&fit=crop&w=3400&q=80"
              alt="member-4"
            />
            <img
              src="https://images.unsplash.com/photo-1484187216010-59798e9cc726?ixlib=rb-1.2.1&auto=format&fit=crop&w=955&q=80"
              alt="member-5"
            />
          </div>
          <br></br><br></br>
        </div>
        
        <>
    <div style={style} className="c1">
      <p>ENROLLED</p>
      <Progress.Circle percent={70} strokeColor="green"/>
    </div>
    <div style={style} className="c2">
      <p>UNENROLLED</p>
      <Progress.Circle percent={30}  strokeColor="red"/>
    </div>
    <div style={style} className="c3">
      <p>INSTITUTION</p>
      <Progress.Circle percent={100} />
    </div>
    <div style={style} className="c4">
      <p>COURSES</p>
      <Progress.Circle percent={30}  strokeColor="#ffc107"/>
    </div>
    <div style={style} className="c5">
      <p>STUDENTS ENROLLED</p>
      <Progress.Circle percent={70} strokeColor="grey" />
    </div>
  </>
  <div><p></p><br></br></div>
  <div><p></p><br></br></div><div><p></p><br></br></div><div><p></p><br></br></div>   
    </div></div>
   
</>

      </>
    )
}
export default Dashboard